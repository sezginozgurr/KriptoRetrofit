package com.example.kriptoretrofit.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kriptoretrofit.holder.CrytoHolder
import com.example.kriptoretrofit.model.CryptoModel


class RecycleAdapter(val crytoList: List<CryptoModel>) :
    RecyclerView.Adapter<CrytoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrytoHolder {
        return CrytoHolder(parent)
    }

    override fun getItemCount(): Int = crytoList.size

    override fun onBindViewHolder(holder: CrytoHolder, position: Int) {
        holder.bind(crytoList[position])
    }
}