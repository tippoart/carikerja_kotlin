package com.example.rvsi05

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Edit_user : AppCompatActivity() {
    private lateinit var tiket: SharedPreferences
    private lateinit var etNama: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPendidikan: EditText
    private lateinit var etPengalaman: EditText
    private lateinit var etPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_user)
        tiket = getSharedPreferences("User", MODE_PRIVATE)

        etNama = findViewById(R.id.edt_nama_user)
        etEmail = findViewById(R.id.edt_email_user)
        etPendidikan = findViewById(R.id.edt_password_user)
        etPengalaman = findViewById(R.id.edt_pengalaman_user)
        etPassword = findViewById(R.id.edt_pendidikan_user)
        val btnSave: Button = findViewById(R.id.btn_simpan_user)

        etNama.setText(tiket.getString("user_nama", null))
        etEmail.setText(tiket.getString("user_email", null))
        etPendidikan.setText(tiket.getString("user_pendidikan", null))
        etPengalaman.setText(tiket.getString("user_pengalaman", null))
        etPassword.setText(tiket.getString("user_password", null))

        btnSave.setOnClickListener {
            saveEditedData()
        }
    }

    private fun saveEditedData() {
        val editedNama = etNama.text.toString()
        val editedEmail = etEmail.text.toString()
        val editedPendidikan = etPendidikan.text.toString()
        val editedPengalaman = etPengalaman.text.toString()
        val editedPassword = etPassword.text.toString()

        val editor: SharedPreferences.Editor = tiket.edit()
        editor.putString("user_nama", editedNama)
        editor.putString("user_email", editedEmail)
        editor.putString("user_pendidikan", editedPendidikan)
        editor.putString("user_pengalaman", editedPengalaman)
        editor.putString("user_password", editedPassword)
        editor.apply()

        val intent = Intent(this, Home_page::class.java)
        startActivity(intent)
    }
}