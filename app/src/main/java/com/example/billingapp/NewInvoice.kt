package com.example.billingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.billingapp.databinding.ActivityNewInvoiceBinding

class NewInvoice : AppCompatActivity() {
    private lateinit var binding: ActivityNewInvoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarNewInvoice)
    }
}