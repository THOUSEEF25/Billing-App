package com.example.billingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.billingapp.databinding.ActivityMainBinding
import com.example.billingapp.fragments.Dashboard
import com.example.billingapp.fragments.Invoicing
import com.example.billingapp.fragments.ShopInfo

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(Dashboard())

        binding.bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.dashboard -> setFragment(Dashboard())
                R.id.invoicing -> setFragment(Invoicing())
                R.id.shop_info -> setFragment(ShopInfo())

                else -> false
            }

            return@setOnItemSelectedListener true
        }

        binding.fabNewInvoice.setOnClickListener {

            val intent = Intent(this, NewInvoice::class.java)
            startActivity(intent)
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }
}