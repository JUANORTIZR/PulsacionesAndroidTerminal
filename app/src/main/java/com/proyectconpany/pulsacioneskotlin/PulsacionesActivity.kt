package com.proyectconpany.pulsacioneskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PulsacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pulsaciones)

        var botonVolver = findViewById<ImageView>(R.id.botonAtras)

        botonVolver.setOnClickListener{finish()}

        var pulsacion = findViewById<TextView>(R.id.total)
        var intent : Intent = getIntent()
        var pulsacionTotal:Long = 0
        pulsacionTotal = intent.getLongExtra("pulsacion", 0)
        pulsacion.setText(pulsacionTotal.toString())
    }
}