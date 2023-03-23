package com.example.neom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.neom.databinding.ActivityMainBinding
import com.example.neom.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.signupBTN.setOnClickListener {
            val email = binding.signupemailEDTXT.toString()
            val username = binding.signupEDTXT.toString()
            val pass = binding.signuppwdEDTXT.toString()
            if(email.isNotEmpty() && pass.isNotEmpty() && username.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                    }
                }
            }else{
                Toast.makeText(this, "Empty fields are not allowed!!", Toast.LENGTH_SHORT)
            }
        }
        binding.loginTXT.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}