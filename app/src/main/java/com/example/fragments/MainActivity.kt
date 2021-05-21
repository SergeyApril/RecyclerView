package com.example.fragments

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), ListContactDetails_Fragment.OnButtonListener,NameFragment.OnTextViewListener {
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

    override fun onTextViewCLicked(view: View) {
        Log.d("test","Click")
        when(view.id){

                R.id.tvPersonName -> { Toast.makeText(this, "Name", Toast.LENGTH_SHORT).show()
                val etPersonNameFragment = EditNameFragment()
                    ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.contForPersonName,etPersonNameFragment)
                    ft.addToBackStack(null)
                    ft.commit()
                }
            R.id.tvPersonSurname -> { Toast.makeText(this, "Surname", Toast.LENGTH_SHORT).show()
                val etPersonSurnameFragment = EditSurnameFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.contForPersonSurname,etPersonSurnameFragment)
                ft.addToBackStack(null)
                ft.commit()
            }
            R.id.tvPersonAge -> { Toast.makeText(this, "Age", Toast.LENGTH_SHORT).show()
                val etPersonAgeFragment = EditAgeFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.contForPersonAge,etPersonAgeFragment)
                ft.addToBackStack(null)
                ft.commit()
            }

        }

    }
}