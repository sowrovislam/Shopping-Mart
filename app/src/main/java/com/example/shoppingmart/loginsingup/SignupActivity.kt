package com.example.shoppingmart.loginsingup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoppingmart.R
import com.example.shoppingmart.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import kotlin.toString

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.SignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        auth = FirebaseAuth.getInstance()

        binding.Register.setOnClickListener {


            val email = binding.Email.text.toString().trim()
            val username = binding.username.text.toString().trim()
            val password = binding.Password.text.toString().trim()
            val repeatPassword = binding.Repeatpassword.text.toString().trim()




            if (email.isEmpty() || username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {

                Toast.makeText(this, "Please Fill All  the Details", Toast.LENGTH_SHORT).show()


            } else if (password != repeatPassword) {


                Toast.makeText(this, "Repeat Password Must Be Same", Toast.LENGTH_SHORT).show()


            } else {


                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->

                        if (task.isSuccessful) {

                            Toast.makeText(this, " Registration Successful", Toast.LENGTH_SHORT)
                                .show()

                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {


                            Toast.makeText(
                                this,
                                " Registration Errr ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()


                        }


                    }


            }


        }


    }
}