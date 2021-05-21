package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


class NameFragment : Fragment() {
    private lateinit var onTextViewListener: OnTextViewListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tvPersonName: TextView = view.findViewById(R.id.tvPersonName)
        if (arguments != null) {
            tvPersonName.text = arguments?.getString("name").toString()}
            tvPersonName.setOnClickListener {
                onTextViewListener.onTextViewCLicked(view.findViewById(R.id.tvPersonName))
            }

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        onTextViewListener = context as OnTextViewListener

    }

    interface OnTextViewListener {
        fun onTextViewCLicked(view: View) {}

    }
}