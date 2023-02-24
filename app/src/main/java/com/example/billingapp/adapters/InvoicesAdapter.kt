package com.example.billingapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billingapp.databinding.InvoiceItemsBinding

class InvoicesAdapter(private val context: Context,private val list: ArrayList<String>) :
    RecyclerView.Adapter<InvoicesAdapter.Holder>() {
    class Holder(binding: InvoiceItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        val customerName = binding.customerName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(InvoiceItemsBinding.inflate(LayoutInflater.from(context)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.customerName.text = list[position]
    }
}