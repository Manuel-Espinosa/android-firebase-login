package com.example.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
    }

    fun registerUser(view: View) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Basic validation
        if (email.isNotBlank() && password.isNotBlank()) {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    // Sign in success
                    val user = auth.currentUser
                    updateUI(user?.email)
                } else {
                    // If sign in fails, display a message to the user.
                    updateUI(null)
                }
            }
        }
    }

    fun loginUser(view: View) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotBlank() && password.isNotBlank()) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    // Sign in success
                    val user = auth.currentUser
                    updateUI(user?.email)
                } else {
                    // If sign in fails, display a message to the user.
                    updateUI(null)
                }
            }
        }
    }

    private fun updateUI(email: String?) {
        if (email != null) {
            // Switch to logged in UI
            setContentView(R.layout.activity_logged_in)
            findViewById<TextView>(R.id.userEmailTextView).text = email
            findViewById<Button>(R.id.logoutButton).setOnClickListener {
                auth.signOut()
                // Switch back to login UI
                setContentView(R.layout.activity_main)
            }
        } else {
            // Stay at login UI and show error message
            Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
        }
    }
}
