package com.fadhiil2010.latihan13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnMi = findViewById<Button>(R.id.btnMi)
        val btTekkom = findViewById<Button>(R.id.btnTekkom)
        val btngaleri = findViewById<Button>(R.id.btnGaleri)

        btnMi.setOnClickListener {
            val Intent = Intent(this, manajemenInformatika::class.java)
            startActivity(Intent)
        }

        btTekkom.setOnClickListener {
            val Intent = Intent(this, TeknikKomputer::class.java)
            startActivity(Intent)
        }
        btngaleri.setOnClickListener {
            val Intent = Intent(this, RecycleViewCard::class.java)
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}