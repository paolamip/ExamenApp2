package com.example.actividad2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculadora : AppCompatActivity() {
    private lateinit var Numero1: EditText
    private lateinit var Numero2: EditText
    private lateinit var txtResultado: TextView
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMultiplicacion: Button
    private lateinit var btnDivision: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        IniciarComponentes()
        eventosClick()

    }
    fun IniciarComponentes(){
        Numero1 = findViewById(R.id.Numero1)
        Numero2 = findViewById(R.id.Numero2)
        txtResultado = findViewById(R.id.txtResultado)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion)
        btnDivision = findViewById(R.id.btnDivision)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)
    }
    fun eventosClick() {
        btnSuma.setOnClickListener {
            val num1 = Numero1.text.toString()
            val num2 = Numero2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = num1.toFloat() + num2.toFloat()
                txtResultado.text = "Resultado: $resultado"
            }
        }
        btnResta.setOnClickListener {
            val num1 = Numero1.text.toString()
            val num2 = Numero2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = num1.toFloat() - num2.toFloat()
                txtResultado.text = "Resultado: $resultado"
            }
        }
        btnMultiplicacion.setOnClickListener {
            val num1 = Numero1.text.toString()
            val num2 = Numero2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = num1.toFloat() * num2.toFloat()
                txtResultado.text = "Resultado: $resultado"
            }
        }
        btnDivision.setOnClickListener {
            val num1 = Numero1.text.toString()
            val num2 = Numero2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show()
            } else {
                if (num2.toFloat() == 0f) {
                    Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
                } else {
                    val resultado = num1.toFloat() / num2.toFloat()
                    txtResultado.text = "Resultado: $resultado"
                }
            }
        }
        btnLimpiar.setOnClickListener {
            Numero1.text.clear()
            Numero2.text.clear()
            txtResultado.text = "Resultado: 0"
        }

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}