package com.example.rvsi05

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val edt_email: EditText = findViewById(R.id.edt_email)
        val edt_password: EditText = findViewById(R.id.edt_password)
        val btn_login: Button = findViewById(R.id.btn_login)

        btn_login.setOnClickListener {
            val isi_email: String = edt_email.text.toString()
            val isi_password: String = edt_password.text.toString()

            val dbkampus: SQLiteDatabase = openOrCreateDatabase("carikerja", MODE_PRIVATE, null)

            val query= dbkampus.rawQuery(
                "SELECT * FROM user WHERE user_email= '$isi_email' AND user_password='$isi_password'",null)
            val cek = query.moveToNext()

            if(cek){
                val id=query.getString(0)
                val nama=query.getString(1)
                val email=query.getString(2)
                val password=query.getString(3)
                val pengalaman=query.getString(4)
                val pendidikan=query.getString(5)

                val session:SharedPreferences=getSharedPreferences("User", MODE_PRIVATE)
                val buattiket =session.edit()
                buattiket.putString("id",id)
                buattiket.putString("user_nama",nama)
                buattiket.putString("user_email",email)
                buattiket.putString("user_password",password)
                buattiket.putString("user_pengalaman",pengalaman)
                buattiket.putString("user_pendidikan",pendidikan)
                buattiket.commit()

                val pindah :Intent=Intent(this, Home_page::class.java)
                startActivity(pindah)
            }else {
                Toast.makeText(this,"Email atau password salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}