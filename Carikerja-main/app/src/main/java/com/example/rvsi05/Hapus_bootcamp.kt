package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Hapus_bootcamp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hapus_bootcamp)
        val id_mahasiswa_terpilih:String= intent.getStringExtra("id_mahasiswa_terpilih").toString()

        val dbcarikerja: SQLiteDatabase = openOrCreateDatabase("carikerja",MODE_PRIVATE, null)

        val query= dbcarikerja.rawQuery("DELETE  from bootcamp WHERE id_bootcamp='$id_mahasiswa_terpilih'" ,null)
        query.moveToNext()
        val pindah: Intent = Intent(this,Bootcamp::class.java)
        startActivity(pindah)
    }
}