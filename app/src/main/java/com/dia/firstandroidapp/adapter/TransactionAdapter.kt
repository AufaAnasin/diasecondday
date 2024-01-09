package com.dia.firstandroidapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.dia.firstandroidapp.model.Transaction

class TransactionAdapter (private val transactionList: ArrayList<Transaction>):
    RecyclerView.Adapter<TransactionAdapter.ViewHolder(binding.root)> {
    inner class ViewHolder(val binding: ItemTransactionBinding): RecyclerView.ViewHolder(binding.root)
}