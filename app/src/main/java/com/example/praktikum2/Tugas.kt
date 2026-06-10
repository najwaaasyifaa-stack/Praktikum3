package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tugas1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tugas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ivLampu = findViewById<ImageView>(R.id.ivLampu)
        val rbPutih = findViewById<RadioButton>(R.id.rbPutih)
        val rbKuning = findViewById<RadioButton>(R.id.rbKuning)
        val rbBiru = findViewById<RadioButton>(R.id.rbBiru)
        val button = findViewById<Button>(R.id.button)
        var statusLampu = false

        button.setOnClickListener {
            if (statusLampu == false) {

                statusLampu = true
                button.text = "Turn Off"

                if (rbPutih.isChecked) {
                    ivLampu.setImageResource(R.drawable.ic_lampu_on)
                } else if (rbKuning.isChecked) {
                    ivLampu.setImageResource(R.drawable.ic_lampu_kuning)
                } else if (rbBiru.isChecked) {
                    ivLampu.setImageResource(R.drawable.ic_lampu_biru)
                } else {
                    ivLampu.setImageResource(R.drawable.ic_lampu_on)
                }

            } else {

                statusLampu = false
                button.text = "Turn On"
                ivLampu.setImageResource(R.drawable.ic_lampu_off)
            }
        }

        rbPutih.setOnClickListener {
            if (statusLampu == true) {
                ivLampu.setImageResource(R.drawable.ic_lampu_on)
            }
        }

        rbKuning.setOnClickListener {
            if (statusLampu == true) {
                ivLampu .setImageResource(R.drawable.ic_lampu_kuning)
            }
        }

        rbBiru.setOnClickListener {
            if (statusLampu == true) {
                ivLampu.setImageResource(R.drawable.ic_lampu_biru)
            }
        }
    }
}