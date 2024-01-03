package com.example.rvsi05

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class Home_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_page)

        val card_view: LinearLayout = findViewById(R.id.card_view)
        card_view.setOnClickListener {
            val pindah: Intent = Intent(this, Kategori::class.java)
            startActivity(pindah)

        }
        val card_boocame: LinearLayout = findViewById(R.id.bootcamp)
        card_boocame.setOnClickListener {
            val pindah: Intent = Intent(this, Bootcamp::class.java)
            startActivity(pindah)
        }
        val text: LinearLayout = findViewById(R.id.edt_profile)
        text.setOnClickListener {
            val pindah: Intent = Intent(this, Profile::class.java)
            startActivity(pindah)
        }
        val txt_nama:TextView =findViewById(R.id.txt_nama_user)
        val tiket:SharedPreferences=getSharedPreferences("User", MODE_PRIVATE)
        val nama_user:String=tiket.getString("user_nama",null).toString()
        txt_nama.text=nama_user
    }
}