package com.example.neom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.neom.databinding.ActivityResultBinding
import com.google.firebase.auth.FirebaseAuth

class ResultActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")
        binding.emailTXT.text = email
        binding.usernameTXT.text = username
        binding.logoutBTN.setOnClickListener{
            auth.signOut()
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}