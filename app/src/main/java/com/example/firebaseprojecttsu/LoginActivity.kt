package com.example.firebaseprojecttsu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.firebaseprojecttsu.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private val auth = FirebaseAuth.getInstance()

    private fun init(){
        binding.apply {

            loginButton.setOnClickListener {

                val email = loginEmailEditText.text.toString()
                val password = loginPasswordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty()){
                    return@setOnClickListener
                }

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        goToProfile()
                    } else {
                        Toast.makeText(this@LoginActivity, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }

            }

            loginForgotPasswordButton.setOnClickListener {
                startActivity(Intent(this@LoginActivity,ForgotPasswordActivity::class.java))
            }

            loginNotRegisteredButton.setOnClickListener {
                startActivity(Intent(this@LoginActivity,SignUpActivity::class.java))
                finish()
            }
        }

    }

    fun goToProfile(){
        startActivity(Intent(this@LoginActivity,ProfileActivity::class.java))
    }
}