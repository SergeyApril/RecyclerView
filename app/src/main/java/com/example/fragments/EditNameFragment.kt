package com.example.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

class EditNameFragment : Fragment() {
    private lateinit var onEditTextViewListener: OnEditTextViewListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvEditTextPersonName: EditText = view.findViewById(R.id.etPersonName)
        tvEditTextPersonName.setOnClickListener{
            onEditTextViewListener.onEditTextViewCLicked(view)
        }
    }

    public interface OnEditTextViewListener{
        fun onEditTextViewCLicked(view: View) {}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onEditTextViewListener = context as OnEditTextViewListener
    }
}