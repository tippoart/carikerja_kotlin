package com.example.rvsi05

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Beranda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beranda)

        val btn_regis:Button =findViewById(R.id.btn_daftar)
        btn_regis.setOnClickListener {
            val pindah:Intent=Intent( this, Registrasi::class.java)
            startActivity(pindah)
        }
        val btn_masuk:Button =findViewById(R.id.btn_masuk)
        btn_masuk.setOnClickListener {
            val pindah:Intent=Intent( this, Login::class.java)
            startActivity(pindah)
        }
    }
}