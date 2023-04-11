package com.example.firebaseprojecttsu

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseprojecttsu.databinding.ActivityProfileBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {

            signOutButton.setOnClickListener {
                Firebase.auth.signOut()
                startActivity(Intent(this@ProfileActivity,LoginActivity::class.java))
                finish()
            }

            profileUpdatePasswordButton.setOnClickListener {
                startActivity(Intent(this@ProfileActivity,UpdatePasswordActivity::class.java))
            }

        }
    }
}