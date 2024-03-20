package com.example.iva

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)
        val texPrecio = findViewById<EditText>(R.id.texPrecio)
        val texSub = findViewById<TextView>(R.id.texSub)
        val texTotIva = findViewById<TextView>(R.id.texTotIva)
        val texTotal = findViewById<TextView>(R.id.texTotal)

        btnStart.setOnClickListener {
            try {


                val precio = texPrecio.text.toString().toDouble()

                val totIva = (precio / 100) * 18
                val sub = (precio - totIva)
                val total = (totIva + sub)

                texSub.text = sub.toString()
                texTotIva.text = totIva.toString()
                texTotal.text = total.toString()
            } catch (e: NumberFormatException){

                texSub.text = "Error"
                texTotIva.text = "Error"
                texTotal.text = "Error"

            }

        }//Fin de Button (btnStart)
        btnLimpiar.setOnClickListener {
            texPrecio.text.clear()
            texSub.text = "0.0"
            texTotIva.text = "0.0"
            texTotal.text = "0.0"
        }//Fin de Button (btnLimpiar)
    }
}