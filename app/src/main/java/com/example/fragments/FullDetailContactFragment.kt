package com.example.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FullDetailContactFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_full_detail_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName:TextView = view.findViewById(R.id.tvName)
        tvName.text = arguments?.getString("name").toString()
        val tvSurname:TextView = view.findViewById(R.id.tvSurname)
        tvSurname.text = arguments?.getString("surname").toString()
        val tvAge:TextView = view.findViewById(R.id.tvAge)
        tvAge.text = arguments?.getInt("age").toString()
    }

}