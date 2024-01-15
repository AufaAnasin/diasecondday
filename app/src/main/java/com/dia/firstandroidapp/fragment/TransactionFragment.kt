package com.dia.firstandroidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dia.firstandroidapp.adapter.TransactionAdapter
import com.dia.firstandroidapp.databinding.FragmentTransactionBinding
import com.dia.firstandroidapp.model.Transaction
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionFragment : Fragment(), TransactionAdapter.TransactionCalllBack {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentTransactionBinding
    private lateinit var transactionHistoryAdapter: TransactionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTransaction.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }
        val transactionHistoryList = ArrayList<Transaction>()
        transactionHistoryList.add(
            Transaction(12231, 123131.0, "Aufa", "Anasin", "Success", "08:23:23 - 25/01/24", "Transfer")
        )
        transactionHistoryList.add(
            Transaction(12212313, 112331.0, "Aufa", "Anasin", "Success", "08:24:23 - 25/01/24", "Transfer")
        )
        transactionHistoryList.add(
            Transaction(1221231231, 14545431.0, "Aufa", "Anasin", "Success", "08:25:23 - 25/01/24", "Transfer")
        )

        transactionHistoryAdapter = TransactionAdapter(transactionHistoryList, this)
        binding.rvTransaction.adapter = transactionHistoryAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransactionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onTransactionSelected(transaction: Transaction) {
        Snackbar.make(binding.root, "Receiver: ${transaction.receiverName}, Amount: ${transaction.amount}", Snackbar.LENGTH_LONG).show()
    }
}