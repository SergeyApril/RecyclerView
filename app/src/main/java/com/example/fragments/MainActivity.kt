package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), ListContactDetails_Fragment.OnButtonListener {
    private lateinit var ft: FragmentTransaction


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragmentListContact()
    }

    private fun initFragmentListContact() {
        var lcDetails = ListContactDetails_Fragment()
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.laMain, lcDetails)
        ft.commit()
    }

    override fun onButtonCLicked(person: Person) {
        var lcFullDetails = FullDetailContactFragment()
        var bundle = Bundle()
        bundle.putString("name",person.name)
        bundle.putInt("age",person.age)
        bundle.putString("surname",person.surname)
        lcFullDetails.arguments = bundle
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.laMain, lcFullDetails)
        ft.commit()


    }
}