package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Tambah_bootcamp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_bootcamp)

            val edt_nama:EditText=findViewById(R.id.edt_nama)
            val edt_Tanggal:EditText=findViewById(R.id.edt_tanggal)
            val edt_Benefit:EditText=findViewById(R.id.edt_benefit)
            val edt_pelakasanaan:EditText=findViewById(R.id.edt_pelaksanaan)
            val edt_perusahaan:EditText=findViewById(R.id.edt_perusahaan)
            val btn_simpan:Button=findViewById(R.id.btn_simpan_bootcamp)

btn_simpan.setOnClickListener{
    val isi_nama:String=edt_nama.text.toString()
    val isi_tanggal:String=edt_Tanggal.text.toString()
    val isi_benefit:String=edt_Benefit.text.toString()
    val isi_pelaksanaan:String=edt_pelakasanaan.text.toString()
    val isi_perusahaan:String=edt_perusahaan.text.toString()

    val dbkampus:SQLiteDatabase=openOrCreateDatabase("carikerja",MODE_PRIVATE,null )
    val eksekutor=dbkampus.rawQuery("Insert into  bootcamp (nama_bootcamp,pendaftaran_bootcamp,benefit_bootcamp,pelaksanaan_bootcamp,perusahaan_bootcamp)VALUES('$isi_nama','$isi_tanggal','$isi_benefit','$isi_pelaksanaan','$isi_perusahaan')",null)
    eksekutor.moveToNext()
    val pindah:Intent=Intent(this,Bootcamp::class.java)
    startActivity(pindah)
}
        }
    }