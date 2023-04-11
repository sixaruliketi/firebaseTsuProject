package com.example.firebaseprojecttsu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseprojecttsu.databinding.ActivityUpdatePasswordBinding
import com.google.firebase.auth.FirebaseAuth

class UpdatePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            updatePasswordButton.setOnClickListener {
                val password = updatePasswordEditText.text.toString()

                FirebaseAuth.getInstance().currentUser?.updatePassword(password)?.addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this@UpdatePasswordActivity, "password updated", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this@UpdatePasswordActivity, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}