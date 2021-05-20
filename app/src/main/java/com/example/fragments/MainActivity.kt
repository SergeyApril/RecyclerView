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
     lateinit var ft: FragmentTransaction


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
        var lcPersonNameFragment = NameFragment()
        var lcPersonSurnameFragment = SurnameFragment()
        var lcPersonAgeFragment = AgeFragment()
        var bundlePersonName = Bundle()
        var bundlePersonSurname = Bundle()
        var bundlePersonAge = Bundle()
        bundlePersonName.putString("name",person.name)
        bundlePersonAge.putInt("age",person.age)
        bundlePersonSurname.putString("surname",person.surname)
        lcPersonNameFragment.arguments=bundlePersonName
        lcPersonAgeFragment.arguments=bundlePersonAge
        lcPersonSurnameFragment.arguments=bundlePersonSurname
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.laMain, lcFullDetails)
        ft.commit()
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.contForPersonName, lcPersonNameFragment)
        ft.commit()
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.contForPersonSurname, lcPersonSurnameFragment)
        ft.commit()
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.contForPersonAge, lcPersonAgeFragment)
        ft.commit()
    }
}