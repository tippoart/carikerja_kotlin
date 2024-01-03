package com.example.rvsi05

import android.annotation.SuppressLint
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Ubah_pekerjaan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubah_pekerjaan)

        val id_mahasiswa_terpilih:String = intent.getStringExtra("id_mahasiswa_terpilih").toString()

        val dbkampus:SQLiteDatabase =openOrCreateDatabase("carikerja", MODE_PRIVATE, null)
        val ambil = dbkampus.rawQuery("Select * from Pekerjaan where id='$id_mahasiswa_terpilih'",null)
        ambil.moveToNext()

        val isi_perusahaan:String =ambil.getString(1)
        val isi_pekerjaan:String =ambil.getString(2)
        val isi_alamat:String =ambil.getString(3)
        val isi_gaji:String =ambil.getString(4)

        val edt_perusahaan:EditText=findViewById(R.id.edt_perusahaan)
        val edt_pekerjaan:EditText=findViewById(R.id.edt_pekerjaan)
        val edt_alamat:EditText=findViewById(R.id.edt_alamat)
        val edt_gaji:EditText=findViewById(R.id.edt_gaji)

        val btn_simpan:Button=findViewById(R.id.btn_simpan)

        edt_perusahaan.setText(isi_perusahaan)
        edt_pekerjaan.setText(isi_pekerjaan)
        edt_alamat.setText(isi_alamat)
        edt_gaji.setText(isi_gaji)

        btn_simpan.setOnClickListener {
            val perusahaan_baru:String =edt_perusahaan.text.toString()
            val pekerjaan_baru:String =edt_pekerjaan.text.toString()
            val alamat_baru:String =edt_alamat.text.toString()
            val gaji_baru:String =edt_gaji.text.toString()

            val ngubah=dbkampus.rawQuery("Update pekerjaan set perusahaan='$perusahaan_baru', pekerjaan='$pekerjaan_baru', alamat='$alamat_baru', gaji='$gaji_baru' where id='$id_mahasiswa_terpilih'",null)
            ngubah.moveToNext()
            val pindah:Intent= Intent(this,Kategori::class.java)
            startActivity(pindah)
        }
    }
}