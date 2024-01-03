package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Bootcamp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bootcamp)
        val rv_bootcamp: RecyclerView =findViewById(R.id.rv_bootcamp)

        val id :MutableList<String> = mutableListOf()
        val nama:MutableList<String> = mutableListOf()
        val tanggal_pendaftaran:MutableList<String> = mutableListOf()
        val benefit:MutableList<String> = mutableListOf()
        val pelaksanaan:MutableList<String> = mutableListOf()
        val perusahaan:MutableList<String> = mutableListOf()

        val dbkampus: SQLiteDatabase = openOrCreateDatabase("carikerja",MODE_PRIVATE, null)
        val gali_mahasiswa= dbkampus.rawQuery("SELECT * from bootcamp",null)

        while (gali_mahasiswa.moveToNext() )
        {
            id.add(gali_mahasiswa.getString(0))
            nama.add(gali_mahasiswa.getString(1))
           tanggal_pendaftaran.add(gali_mahasiswa.getString(2))
           benefit.add(gali_mahasiswa.getString(3))
           pelaksanaan.add(gali_mahasiswa.getString(4))
           perusahaan.add(gali_mahasiswa.getString(5))

        }
        val mi:Bootcamp_Item = Bootcamp_Item(this,id,nama,tanggal_pendaftaran,benefit,pelaksanaan,perusahaan)
        rv_bootcamp.adapter = mi
        rv_bootcamp.layoutManager = GridLayoutManager(this, perusahaan.size,LinearLayoutManager.HORIZONTAL, false)

        val btn_tambah: Button =findViewById(R.id.btn_tambah)
        btn_tambah.setOnClickListener {
            val pindah: Intent = Intent( this, Tambah_bootcamp::class.java)
            startActivity(pindah)
        }
        val btn_kembali: ImageView =findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener {
            val pindah: Intent = Intent( this, Home_page::class.java)
            startActivity(pindah)
        }
    }
    }
