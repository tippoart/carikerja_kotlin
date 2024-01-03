package com.example.rvsi05

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Registrasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrasi)


                val edt_nama: EditText = findViewById(R.id.edt_nama)
                val edt_email: EditText = findViewById(R.id.edt_email)
                val edt_password: EditText = findViewById(R.id.edt_password)
                val btn_Registrasi: Button = findViewById(R.id.btn_registrasi)

                btn_Registrasi.setOnClickListener {
                    val isi_nama: String = edt_nama.text.toString()
                    val isi_email: String = edt_email.text.toString()
                    val isi_password: String = edt_password.text.toString()


                    val dbcarikerja: SQLiteDatabase =
                        openOrCreateDatabase("carikerja", MODE_PRIVATE, null)
                    val eksekutor = dbcarikerja.rawQuery(
                        "INSERT INTO user(user_nama,user_email,user_password) VALUES('$isi_nama','$isi_email','$isi_password')",
                        null
                    )
                    eksekutor.moveToNext()

                    // pindah lagi dr tambah ke mhs
                    val pindah: Intent = Intent(this, Login::class.java)
                    startActivity(pindah)
                }
            }
        }

