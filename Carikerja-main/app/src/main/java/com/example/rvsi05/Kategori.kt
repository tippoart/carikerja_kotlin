package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Kategori : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kategori)
        val rv_kategori:RecyclerView=findViewById(R.id.rv_kategori)

        val id :MutableList<String> = mutableListOf()
        val perusahaan:MutableList<String> = mutableListOf()
        val pekerjaan:MutableList<String> = mutableListOf()
        val alamat:MutableList<String> = mutableListOf()
        val gaji:MutableList<String> = mutableListOf()

        val dbkampus: SQLiteDatabase = openOrCreateDatabase("carikerja",MODE_PRIVATE, null)
        val gali_mahasiswa= dbkampus.rawQuery("SELECT * from pekerjaan",null)

        while (gali_mahasiswa.moveToNext() )
        {
            id.add(gali_mahasiswa.getString(0))
            perusahaan.add(gali_mahasiswa.getString(1))
            pekerjaan.add(gali_mahasiswa.getString(2))
            alamat.add(gali_mahasiswa.getString(3))
            gaji.add(gali_mahasiswa.getString(4))

        }


        val mi:Kategori_item = Kategori_item(this,id,perusahaan,pekerjaan,alamat,gaji)

        rv_kategori.adapter = mi
        rv_kategori.layoutManager = GridLayoutManager(this, gaji.size,LinearLayoutManager.HORIZONTAL, false)

        val btn_tambah: Button =findViewById(R.id.btn_tambah)
        btn_tambah.setOnClickListener {
            val pindah: Intent = Intent( this, Tambah_pekerjaan::class.java)
            startActivity(pindah)
        }

        val kembali: ImageView =findViewById(R.id.btn_kembali)
        kembali.setOnClickListener {
            val pindah: Intent = Intent( this, Home_page::class.java)
            startActivity(pindah)
        }
    }


}