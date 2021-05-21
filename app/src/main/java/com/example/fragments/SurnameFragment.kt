package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SurnameFragment : Fragment(),NameFragment.OnTextViewListener {
    private lateinit var onTextViewListener : NameFragment.OnTextViewListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_surname, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvSurname: TextView = view.findViewById(R.id.tvPersonSurname)
        tvSurname.text = arguments?.getString("surname").toString()
        tvSurname.setOnClickListener{
            onTextViewListener.onTextViewCLicked(view.findViewById(R.id.tvPersonSurname))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onTextViewListener = context as NameFragment.OnTextViewListener
    }
}