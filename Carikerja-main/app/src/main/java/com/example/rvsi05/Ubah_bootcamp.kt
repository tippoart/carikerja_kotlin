package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Ubah_bootcamp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ubah_bootcamp)

        val id_mahasiswa_terpilih:String = intent.getStringExtra("id_mahasiswa_terpilih").toString()

        val dbkampus:SQLiteDatabase =openOrCreateDatabase("carikerja", MODE_PRIVATE, null)
        val ambil = dbkampus.rawQuery("Select * from bootcamp where id_bootcamp='$id_mahasiswa_terpilih'",null)
        ambil.moveToNext()

        val isi_nama:String =ambil.getString(1)
        val isi_tanggal:String =ambil.getString(2)
        val isi_benefit:String =ambil.getString(3)
        val isi_pelaksanaan:String =ambil.getString(4)
        val isi_perusahaan:String =ambil.getString(5)

        val edt_nama:EditText=findViewById(R.id.edt_nama)
        val edt_tanggal:EditText=findViewById(R.id.edt_tanggal)
        val edt_benefit:EditText=findViewById(R.id.edt_benefit)
        val edt_pelaksanaan:EditText=findViewById(R.id.edt_pelaksanaan)
        val edt_perusahaan:EditText=findViewById(R.id.edt_perusahaan)

        val btn_simpan:Button=findViewById(R.id.btn_simpan)

        edt_nama.setText(isi_nama)
        edt_tanggal.setText(isi_tanggal)
        edt_benefit.setText(isi_benefit)
        edt_pelaksanaan.setText(isi_pelaksanaan)
        edt_perusahaan.setText(isi_perusahaan)

        btn_simpan.setOnClickListener {
            val nama_bootcamp:String =edt_nama.text.toString()
            val pendaftaran_bootcamp:String =edt_tanggal.text.toString()
            val benefit_bootcamp:String =edt_benefit.text.toString()
            val pelaksanaan_bootcamp:String =edt_pelaksanaan.text.toString()
            val perusahaan_bootcamp:String =edt_perusahaan.text.toString()

            val ngubah=dbkampus.rawQuery("Update bootcamp set nama_bootcamp='$nama_bootcamp', pendaftaran_bootcamp='$pendaftaran_bootcamp', benefit_bootcamp='$benefit_bootcamp', pelaksanaan_bootcamp='$pelaksanaan_bootcamp', perusahaan_bootcamp='$perusahaan_bootcamp' where id_bootcamp='$id_mahasiswa_terpilih'",null)
            ngubah.moveToNext()
            val pindah:Intent= Intent(this,Bootcamp::class.java)
            startActivity(pindah)
        }


        }
    }
