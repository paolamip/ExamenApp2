package com.example.actividad2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        IniciarComponentes()
        eventosClick()

    }

    fun IniciarComponentes() {
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContrasena = findViewById(R.id.txtContrasena)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)
    }

    fun eventosClick() {
        btnIngresar.setOnClickListener(){
            val usuario = txtUsuario.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (usuario.isEmpty() || contrasena.isEmpty()) {

                Toast.makeText(this, "Por favor, ingrese usuario y contraseña", Toast.LENGTH_SHORT)
                    .show()
            } else {

                Toast.makeText(this, "Bienvenido, $usuario", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, Calculadora::class.java)
                startActivity(intent)
            }
        }
    }
}
