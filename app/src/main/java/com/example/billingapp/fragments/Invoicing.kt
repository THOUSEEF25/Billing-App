package com.example.billingapp.fragments

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billingapp.R
import com.example.billingapp.adapters.InvoicesAdapter
import com.example.billingapp.databinding.FragmentInvoicingBinding


class Invoicing : Fragment() {

    val list = ArrayList<String>()

    @Deprecated("Deprecated in Java")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_invoicing, container, false)

        val binding = FragmentInvoicingBinding.bind(view)

        list.add("Sulaiman Sha")
        list.add("Ertugrul")
        list.add("Gunduz")
        list.add("Savci")
        list.add("Osman")
        list.add("Orhan")
        list.add("Alaudin")

        binding.todayRV.setHasFixedSize(true)
        binding.todayRV.layoutManager = LinearLayoutManager(requireContext())
        binding.todayRV.adapter = InvoicesAdapter(requireContext(),list)

        binding.allRV.setHasFixedSize(true)
        binding.allRV.layoutManager = LinearLayoutManager(requireContext())
        binding.allRV.adapter = InvoicesAdapter(requireContext(),list)

        binding.dropDownMenu1.setOnClickListener {
            visibilityToggle(binding.todayRV, binding.dropUpArrow1, binding.parentTodayInvoices, binding.parentLinearLayout)
        }

        binding.dropDownMenu2.setOnClickListener {
            visibilityToggle(binding.allRV, binding.dropUpArrow2, binding.parentAllInvoices, binding.parentLinearLayout)
        }

        return view
    }

    private fun visibilityToggle(view: View, image: ImageView, parent: LinearLayout, parentMain: LinearLayout) {

        val layoutTransition = LayoutTransition()
        val layoutTransitionParent = LayoutTransition()

        if (view.isVisible) {

            layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            parentMain.layoutTransition = layoutTransitionParent
            parent.layoutTransition = layoutTransition

            view.visibility = View.GONE
            image.setImageResource(R.drawable.ic_arrow_drop_down)
        }
        else {

            layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            parentMain.layoutTransition = layoutTransitionParent
            parent.layoutTransition = layoutTransition

            view.visibility = View.VISIBLE
            image.setImageResource(R.drawable.ic_arrow_drop_up)
        }
    }
}