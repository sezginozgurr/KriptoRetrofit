package com.example.kriptoretrofit.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kriptoretrofit.R
import com.example.kriptoretrofit.model.CryptoModel


class CrytoHolder(container: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(container.context)
        .inflate(
            R.layout.row_item,
            container, false
        )
) {
    val txtTitle: TextView = itemView.findViewById(R.id.txt_name)
    val txtPrice: TextView = itemView.findViewById(R.id.txt_price)

    fun bind(cryptomodel: CryptoModel) {
        txtTitle.text = cryptomodel.currency
        txtPrice.text = cryptomodel.price
    }
}
