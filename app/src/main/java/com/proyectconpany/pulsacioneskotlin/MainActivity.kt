package com.proyectconpany.pulsacioneskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Probando commit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonCalcular.setOnClickListener{
            val intent = Intent(this@MainActivity, CalcularPulsacionesActivity:: class.java)
            startActivity(intent)
        }
    }
}