package com.example.rvsi05

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    private lateinit var tiket: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val txt_nama: TextView = findViewById(R.id.nama_lengkap)
        val txt_email: TextView = findViewById(R.id.Email)
        val txt_pendidikan: TextView = findViewById(R.id.pendidikan)
        val txt_pengalaman: TextView = findViewById(R.id.pengalaman)
        val txt_paswword: TextView = findViewById(R.id.password)

        tiket = getSharedPreferences("User", MODE_PRIVATE)

        val nama_user: String = tiket.getString("user_nama", null).toString()
        val email: String = tiket.getString("user_email", null).toString()
        val pendidikan: String = tiket.getString("user_pendidikan", null).toString()
        val pengalaman: String = tiket.getString("user_pengalaman", null).toString()
        val password: String = tiket.getString("user_password", null).toString()

        txt_nama.text = nama_user
        txt_email.text = email
        txt_pendidikan.text = pendidikan
        txt_pengalaman.text = pengalaman
        txt_paswword.text = password

        val btn_logout:Button=findViewById(R.id.btn_Logout)
        btn_logout.setOnClickListener {
            val edit_tiket=tiket.edit()
            edit_tiket.clear()
            edit_tiket.commit()

            val keluar:Intent=Intent(this,Login::class.java)
            startActivity(keluar)
            finish()
        }

        val btnEditProfile: Button = findViewById(R.id.btn_edit_user)
        btnEditProfile.setOnClickListener {
            startEditProfileActivity()
        }
        val btn_kembali: ImageView =findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener {
            val pindah: Intent = Intent( this, Home_page::class.java)
            startActivity(pindah)
        }
    }

    private fun startEditProfileActivity() {
        val intent = Intent(this, Edit_user::class.java)
        startActivity(intent)
    }
}

