package com.proyectconpany.pulsacioneskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class CalcularPulsacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_pulsaciones)
       // val db = FirebaseFirestore.getInstance()
        var botonRegistro = findViewById<ImageView>(R.id.botonRegistro)
        var textIdentificacion = findViewById<TextView>(R.id.textIdentificacion)
        var textNombre = findViewById<TextView>(R.id.TextNombre)
        var textEdad = findViewById<TextView>(R.id.TextEdad)
        var radioMasculino = findViewById<RadioButton>(R.id.radioMasculino)
        var radioFemino = findViewById<RadioButton>(R.id.radioFemenino)
        var pulsacion: Long = 0;
        botonRegistro.setOnClickListener {
            CalcularPulsacion(
                textNombre,
                textIdentificacion,
                textEdad,
                radioFemino,
                pulsacion,
                radioMasculino
            )
        }

       /* botonRegistro.setOnClickListener{
            db.collection("Usuarios").document(textIdentificacion).set(
                hashMapOf("Identificacion" to textIdentificacion,
                    "Nombre" to textNombre,
                    "Sexo" to "sexo",
                    "Edad" to textEdad,
                    "Pulsacion" to "pulsacion1"
                )
            )
        }*/

    }


    private fun CalcularPulsacion(
        textNombre: TextView,
        textIdentificacion: TextView,
        textEdad: TextView,
        radioFemenino: RadioButton,
        pulsacion: Long,
        radioMasculino: RadioButton
    ) {
        //val db = FirebaseFirestore.getInstance()
        var pulsacion1 = pulsacion
        val nombre = textNombre.text.toString()
        val identificacion = textIdentificacion.text.toString()
        var edad = 0;
        var sexo:String
        try {
            edad = textEdad.text.toString().toInt()
        } catch (e: Exception) {

            Toast.makeText(
                this@CalcularPulsacionesActivity,
                "Digite una edad valida", Toast.LENGTH_SHORT
            ).show()
        }

        if (identificacion.isEmpty()) {
            Toast.makeText(
                this@CalcularPulsacionesActivity,
                "Digite una identificacion", Toast.LENGTH_SHORT
            ).show()
        } else if (nombre.isEmpty()) {
            Toast.makeText(
                this@CalcularPulsacionesActivity,
                "Digite un nombre", Toast.LENGTH_SHORT
            ).show()
        } else if (edad <= 0) {

            Toast.makeText(
                this@CalcularPulsacionesActivity,
                "Digite una edad valida", Toast.LENGTH_SHORT
            ).show()
        } else {
            when {

                radioFemenino.isChecked -> {
                    sexo = "Femenino";
                    pulsacion1 = ((220 - edad) / 10).toLong()
                    EnviarPulsacion(pulsacion1)

                }
                radioMasculino.isChecked -> {
                    sexo = "Masculino"
                    pulsacion1 = ((210 - edad) / 10).toLong()
                    EnviarPulsacion(pulsacion1)

                }
                else -> {
                    Toast.makeText(
                        this@CalcularPulsacionesActivity,
                        "Seleccione un sexo", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun EnviarPulsacion(pulsacion1: Long) {
        var intent =
            Intent(this@CalcularPulsacionesActivity, PulsacionesActivity::class.java)
        intent.putExtra("pulsacion", pulsacion1)
        startActivity(intent)
    }
}
