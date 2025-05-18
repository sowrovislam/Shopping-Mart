package com.example.shoppingmart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shoppingmart.databinding.ActivityHomeBinding
import com.example.shoppingmart.loginsingup.LoginActivity
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


//        binding.button.setOnClickListener {
//
//            if (auth.currentUser != null) {
//                auth.signOut()
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finishAffinity()
//            }
//
//        }



           binding.bottomNavigation.setOnItemSelectedListener { item ->
               when (item.itemId) {
                   R.id.home -> {
                       // Switch to home fragment
                       true
                   }
                   R.id.favourite -> {
                       // Switch to dashboard fragment
                       true
                   } R.id.shopping -> {
                   // Switch to dashboard fragment
                   true
               }
                   R.id.profile -> {
                       // Switch to notifications fragment
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