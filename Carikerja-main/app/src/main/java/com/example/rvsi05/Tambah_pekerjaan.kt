package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Tambah_pekerjaan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_pekerjaan)

        val edt_perusahaan:EditText=findViewById(R.id.edt_perusahaan)
        val edt_pekerjaan:EditText=findViewById(R.id.edt_pekerjaan)
        val edt_alamat:EditText=findViewById(R.id.edt_alamat)
        val edt_gaji:EditText=findViewById(R.id.edt_gaji)
        val btn_simpan:Button = findViewById(R.id.btn_simpan)

        btn_simpan.setOnClickListener{
            val isi_perusahaan:String=edt_perusahaan.text.toString()
            val isi_pekerjaan:String=edt_pekerjaan.text.toString()
            val isi_alamat:String=edt_alamat.text.toString()
            val isi_gaji:String=edt_gaji.text.toString()

            val dbkampus:SQLiteDatabase = openOrCreateDatabase("carikerja", MODE_PRIVATE,null )
            val eksekutor=dbkampus.rawQuery("INSERT INTO pekerjaan (perusahaan,pekerjaan,alamat,gaji)VALUES('$isi_perusahaan','$isi_pekerjaan','$isi_alamat','$isi_gaji')",null)
            eksekutor.moveToNext()
            val pindah:Intent=Intent(this,Kategori::class.java)
            startActivity(pindah)
        }
    }
}