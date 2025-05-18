package com.example.shoppingmart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.shoppingmart.databinding.ActivityHomeBinding
import com.example.shoppingmart.loginsingup.LoginActivity
import com.example.shoppingmart.loginsingup.profileActivity

import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        lateinit var auth: FirebaseAuth
        auth=FirebaseAuth.getInstance()


           binding.bottomNavigation.setOnItemSelectedListener { item ->
               when (item.itemId) {
                   R.id.home -> {

                       findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
                       true
                   }
                   R.id.favourite -> {
                       // Switch to dashboard fragment
                       true
                   } R.id.shopping -> {
//                   startActivity(Intent(this, CardActivity::class.java))


                   true
               }
                   R.id.profile -> {

                       startActivity(Intent(this, profileActivity::class.java))
                       true
                   }
                   else -> false
               }}


    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        finishAffinity()
    }







}