package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class AgeFragment : Fragment(),NameFragment.OnTextViewListener {
    private lateinit var onTextViewListener : NameFragment.OnTextViewListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvAge: TextView = view.findViewById(R.id.tvPersonAge)
        tvAge.text = arguments?.getInt("age").toString()
        tvAge.setOnClickListener{
            onTextViewListener.onTextViewCLicked(view.findViewById(R.id.tvPersonAge))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onTextViewListener = context as NameFragment.OnTextViewListener
    }

}
