package com.example.rvsi05

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Kategori_item(
    val ini: Context,
    val id: MutableList<String>,
    val perusahaan: MutableList<String>,
    val pekerjaan: MutableList<String>,
    val alamat: MutableList<String>,
    val gaji : MutableList<String>
) : RecyclerView.Adapter<Kategori_item.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kategori_item.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.kategori_item, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder (iv:View) : RecyclerView.ViewHolder(iv){

        val txt_perusahaan:TextView = iv.findViewById(R.id.txt_perusahaan)
        val txt_pekerjaan:TextView = iv.findViewById(R.id.txt_pekerjaan)
        val txt_alamat:TextView = iv.findViewById(R.id.txt_alamat)
        val txt_gaji:TextView = iv.findViewById(R.id.txt_gaji)
        val btn_hapus: Button = itemView.findViewById(R.id.btn_hapus)
        val btn_ubah: Button = itemView.findViewById(R.id.btn_ubah)

    }

    override fun getItemCount(): Int {
        return perusahaan.size
    }

    override fun onBindViewHolder(holder: Kategori_item.ViewHolder, position: Int) {
        holder.txt_perusahaan.text = perusahaan.get(position)
        holder.txt_pekerjaan.text = pekerjaan.get(position)
        holder.txt_alamat.text = alamat.get(position)
        holder.txt_gaji.text = gaji.get(position)

        holder.btn_hapus.setOnClickListener {
            val id_mahasiswa_terpilih:String=id.get(position)
            val pindah: Intent = Intent(ini,Hapus_pekerjaan::class.java)
            pindah.putExtra("id_mahasiswa_terpilih", id_mahasiswa_terpilih)
            ini.startActivity(pindah)
        }
        holder.btn_ubah.setOnClickListener {
            val id_mahasiswa_terpilih:String=id.get(position)
            val pindah: Intent = Intent(ini,Ubah_pekerjaan::class.java)
            pindah.putExtra("id_mahasiswa_terpilih", id_mahasiswa_terpilih)
            ini.startActivity(pindah)
        }



    }

}