package com.example.shoppingmart.loginsingup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoppingmart.HomeActivity
import com.example.shoppingmart.R
import com.example.shoppingmart.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonSignup.setOnClickListener {

            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()



        binding.buttonlogin.setOnClickListener {


            val username = binding.userName.text.toString()

            val pasword = binding.passwrd.text.toString()

            if (username.isEmpty() || pasword.isEmpty()) {


                Toast.makeText(this, "please Fill ALL The Details", Toast.LENGTH_SHORT).show()
            } else {

                auth.signInWithEmailAndPassword(username, pasword).addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        showSnackbar("Login successful", Snackbar.LENGTH_SHORT)
                        startActivity(Intent(this, HomeActivity::class.java))


                    } else {
                        showSnackbar(
                            "Login failed: ${task.exception?.message}", Snackbar.LENGTH_LONG
                        )
                    }


                }


            }


        }


    }

    private fun showSnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(binding.root, message, duration).apply {
            setAction("Dismiss") { dismiss() }
            setActionTextColor(getColor(R.color.red))
        }.show()
    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))


        }
    }


}