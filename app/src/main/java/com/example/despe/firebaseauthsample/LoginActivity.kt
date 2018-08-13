package com.example.despe.firebaseauthsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            performLogin()
        }

        back_to_registration_textview.setOnClickListener {
            finish()
        }
    }

    private fun performLogin() {
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener

                    Log.d("LoginActivity", "Successfully login with email/password: $email/****")
                    Toast.makeText(this, "Successful Login!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Log.d("LoginActivity", "Failed to login user: ${it.message}")
                    Toast.makeText(this, "Failed to login: ${it.message}", Toast.LENGTH_SHORT).show()
                }
    }
}