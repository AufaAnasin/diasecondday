package com.dia.firstandroidapp.model

data class Transaction (
    val id: Int,
    val amount: Double,
    val senderName: String,
    val receiverName: String,
    val transactionStatus: String,
    val date: String,
    val type: String
)