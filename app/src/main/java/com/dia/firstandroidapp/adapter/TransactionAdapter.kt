package com.dia.firstandroidapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dia.firstandroidapp.databinding.ItemTransactionListBinding
import com.dia.firstandroidapp.model.Transaction

class TransactionAdapter(
    val transactionList: ArrayList<Transaction>,
    val transactionCalllBack: TransactionCalllBack

):RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemTransactionListBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener{
                val transactionSelected = transactionList[adapterPosition]
                transactionCalllBack.onTransactionSelected(transactionSelected)
            }
        }
    }

    interface TransactionCalllBack {
        fun onTransactionSelected(transaction: Transaction)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemTransactionListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = transactionList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transactionHistory = transactionList[position]
        with(holder) {
            binding.tvTransactionId.text = transactionHistory.id.toString()
            binding.tvTransactionAmount.text = transactionHistory.amount.toString()
            binding.tvTransactionSender.text = transactionHistory.senderName
            binding.tvTransactionReceiverName.text = transactionHistory.receiverName
            binding.tvTransactionStatusCode.text = transactionHistory.transactionStatus
            binding.tvTransactionDate.text = transactionHistory.date
            binding.tvTransactionType.text = transactionHistory.type

        }
    }
}

