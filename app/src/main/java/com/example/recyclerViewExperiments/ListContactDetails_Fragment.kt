package com.example.recyclerViewExperiments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import java.util.*
import kotlin.collections.ArrayList

public class ListContactDetails_Fragment : Fragment() {

    private var listOfPerson: ArrayList<Person> = arrayListOf()
    private lateinit var onButtonListener: OnButtonListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        onButtonListener = context as OnButtonListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListOfPerson()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v: View = inflater.inflate(R.layout.fragment_list_contact_details_, container, false)
        return onGeneratedViewList(v)
    }

    fun initListOfPerson() {
        for (i in 0..5) {
            listOfPerson.add(i, Person(UUID.randomUUID().toString(), "Name+$i", i,i))
        }
    }

    fun onGeneratedViewList(view: View): View {
        var linLayoutFullList: LinearLayout = view.findViewById(R.id.laFullList)
        var objectPosition: Int = 0
        for (Person in listOfPerson) {
            var lpForTextViewListContacts =
                LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            val tvDetailContact = Button(activity)
            tvDetailContact.layoutParams = lpForTextViewListContacts
            tvDetailContact.text = Person.name
            tvDetailContact.setOnClickListener {
                onButtonListener.onButtonCLicked(Person)
            }
            linLayoutFullList.addView(tvDetailContact)
        }


        return linLayoutFullList
    }

    interface OnButtonListener {
        fun onButtonCLicked(person: Person) {}

    }


}