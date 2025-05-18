package com.example.shoppingmart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingmart.data.ProductAdapter
import com.example.shoppingmart.data.ProductRepository
import com.example.shoppingmart.data.ProductViewModel
import com.example.shoppingmart.data.ProductViewModelFactory
import com.example.shoppingmart.data.data
import com.example.shoppingmart.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
//        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())




        val spanCount = 2 // Number of columns
        val layoutManager = GridLayoutManager(requireContext(), spanCount)
       binding.recyclerView.layoutManager = layoutManager

        // Show progress bar initially
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE

        val repository = ProductRepository()
        val factory = ProductViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ProductViewModel::class.java)

        viewModel.products.observe(viewLifecycleOwner) { products ->
            // Hide progress bar and show RecyclerView when data is loaded
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE

            adapter = ProductAdapter(products)
            binding.recyclerView.adapter = adapter
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            errorMsg?.let {
                // Hide progress bar on error too
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}