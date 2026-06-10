package com.example.praktikum2

import android.os.Bundle
import android.widget.EditText
import android.widget.CheckBox
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etSisiKubus = findViewById<EditText>(R.id.etSisiKubus)
        val cbPilihan1 = findViewById<CheckBox>(R.id.cbPilihan1)
        val cbPilihan2 = findViewById<CheckBox>(R.id.cbPilihan2)
        val cbPilihan3 = findViewById<CheckBox>(R.id.cbPilihan3)
        val btnProsesCheckBox = findViewById<Button>(R.id.btnProsesCheckBox)
        val tvHasilCheckBox = findViewById<TextView>(R.id.tvHasilCheckBox)

        btnProsesCheckBox.setOnClickListener {
            val sisi = etSisiKubus.text.toString().trim().toIntOrNull() ?: 0
            val builder = AlertDialog.Builder(this)
            var hasil1 = sisi * sisi
            var hasil2 = 6 * sisi * sisi
            var hasil3 = sisi * sisi * sisi

            if (cbPilihan1.isChecked && cbPilihan2.isChecked && cbPilihan3.isChecked) {
                tvHasilCheckBox.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nLuas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"

            } else if (cbPilihan1.isChecked && cbPilihan2.isChecked) {
                tvHasilCheckBox.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nLuas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2"

            } else if (cbPilihan2.isChecked && cbPilihan3.isChecked) {
                tvHasilCheckBox.text = "Luas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"

            } else if (cbPilihan1.isChecked && cbPilihan3.isChecked) {
                tvHasilCheckBox.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"

            } else {
                builder.setTitle("Peringatan")
                builder.setMessage("Silahkan Centang Dua Pilihan")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()

                tvHasilCheckBox.text = "--------"
            }
        }

    }
}