package com.example.rvsi05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Bootcamp_Item(
    val ini: Context,
    val id: MutableList<String>,
    val nama: MutableList<String>,
    val tanggal_pendaftaran: MutableList<String>,
    val benefit: MutableList<String>,
    val pelaksanaan : MutableList<String>,
    val perusahaan : MutableList<String>
) : RecyclerView.Adapter<Bootcamp_Item.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Bootcamp_Item.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.bootcamp_item, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(iv: View) : RecyclerView.ViewHolder(iv) {

        val txt_nama: TextView = iv.findViewById(R.id.txt_nama)
        val txt_tanggal_pendaftaran: TextView = iv.findViewById(R.id.txt_tanggal_pendaftaran)
        val txt_benefit: TextView = iv.findViewById(R.id.txt_benefit)
        val txt_pelaksanaan: TextView = iv.findViewById(R.id.txt_pelaksanaan)
        val txt_perusahaan: TextView = iv.findViewById(R.id.txt_perusahaan)
        val btn_hapus: Button = itemView.findViewById(R.id.btn_hapus)
        val btn_ubah: Button = itemView.findViewById(R.id.btn_ubah)
    }

    override fun getItemCount(): Int {
        return perusahaan.size
    }

    override fun onBindViewHolder(holder: Bootcamp_Item.ViewHolder, position: Int) {
        holder.txt_nama.text = nama.get(position)
        holder.txt_tanggal_pendaftaran.text = tanggal_pendaftaran.get(position)
        holder.txt_benefit.text = benefit.get(position)
        holder.txt_pelaksanaan.text = pelaksanaan.get(position)
        holder.txt_perusahaan.text = perusahaan.get(position)

        holder.btn_hapus.setOnClickListener {
            val id_mahasiswa_terpilih: String = id.get(position)
            val pindah: Intent = Intent(ini, Hapus_bootcamp::class.java)
            pindah.putExtra("id_mahasiswa_terpilih", id_mahasiswa_terpilih)
            ini.startActivity(pindah)
        }
        holder.btn_ubah.setOnClickListener {
            val id_mahasiswa_terpilih: String = id.get(position)
            val pindah: Intent = Intent(ini, Ubah_bootcamp::class.java)
            pindah.putExtra("id_mahasiswa_terpilih", id_mahasiswa_terpilih)
            ini.startActivity(pindah)
        }
    }
}