package com.example.tvyg

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val rememberCheckBox = findViewById<CheckBox>(R.id.rememberCheckBox)

        initializeEncryptedSharedPreferences()

        val savedEmail = getSavedEmail()
        val isRemembered = sharedPreferences.getBoolean("remember", false)

        if (auth.currentUser != null && isRemembered && auth.currentUser?.email == savedEmail) {
            auth.currentUser?.reload()?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigateToMenu()
                } else {
                    handleDeletedUser()
                }
            }
        } else {
            clearStoredCredentials()
        }

        if (isRemembered) {
            emailEditText.setText(savedEmail)
            rememberCheckBox.isChecked = true
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val remember = rememberCheckBox.isChecked

            if (email.isNotEmpty() && password.isNotEmpty()) {
                signIn(email, password, remember)
            } else {
                Toast.makeText(this, "Por favor, ingresa el correo y la contraseña", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initializeEncryptedSharedPreferences() {
        try {
            val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
            sharedPreferences = EncryptedSharedPreferences.create(
                "LoginPrefs",
                masterKeyAlias,
                applicationContext,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (e: Exception) {
            // Si hay un error al inicializar EncryptedSharedPreferences, usar SharedPreferences normales
            sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)
            Toast.makeText(this, "No se pudo inicializar el almacenamiento seguro. Se usará almacenamiento normal.", Toast.LENGTH_LONG).show()
        }
    }

    private fun getSavedEmail(): String {
        return try {
            sharedPreferences.getString("email", "") ?: ""
        } catch (e: Exception) {
            // Si hay un error al leer el email, limpiar las preferencias y devolver cadena vacía
            clearStoredCredentials()
            ""
        }
    }

    private fun signIn(email: String, password: String, remember: Boolean) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.reload()?.addOnCompleteListener { reloadTask ->
                        if (reloadTask.isSuccessful) {
                            if (remember) {
                                saveCredentials(email)
                            } else {
                                clearStoredCredentials()
                            }
                            navigateToMenu()
                        } else {
                            handleDeletedUser()
                        }
                    }
                } else {
                    Toast.makeText(this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun handleDeletedUser() {
        auth.signOut()
        clearStoredCredentials()
        Toast.makeText(this, "El usuario ha sido eliminado, por favor inicia sesión nuevamente.", Toast.LENGTH_LONG).show()
    }

    private fun saveCredentials(email: String) {
        try {
            val editor = sharedPreferences.edit()
            editor.putString("email", email)
            editor.putBoolean("remember", true)
            editor.apply()
        } catch (e: Exception) {
            Toast.makeText(this, "No se pudieron guardar las credenciales de forma segura", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearStoredCredentials() {
        try {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        } catch (e: Exception) {
            // Si falla la limpieza, intentar recrear las preferencias
            initializeEncryptedSharedPreferences()
        }
    }

    private fun navigateToMenu() {
        val intent = Intent(this, Menu::class.java)
        startActivity(intent)
        finish()
    }
}