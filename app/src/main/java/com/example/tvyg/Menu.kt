package com.example.tvyg

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Menu : AppCompatActivity() {  // Cambié el nombre a "Menu" con mayúscula inicial
    override fun onCreate(savedInstanceState: Bundle?) {

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_peliculas)  // Asegúrate de que esta sea la actividad correcta

        // Obtener el botón usando findViewById
        val btnPeliculas: AppCompatButton = findViewById(R.id.btn_peliculas)
        val btnLiveTv: AppCompatButton = findViewById(R.id.btn_live_tv)
        val btn_series: AppCompatButton = findViewById(R.id.btn_series)


        btnLiveTv.setOnClickListener {
            // Crear un Intent para iniciar MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // Iniciar la actividad


        }
        btn_series.setOnClickListener {
            // Crear un Intent para iniciar MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)  // Iniciar la actividad
        }
        btnPeliculas.setOnClickListener {
            val intent2 = Intent(this, com.example.tvyg.ListActivity::class.java)
            startActivity(intent2)
        }
    }
}
