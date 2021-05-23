package com.example.recyclerViewExperiments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class PhoneBookAdapter : RecyclerView.Adapter<PhoneBookAdapter.PersonViewHolder>(){
    private var listOfPerson = emptyList<Person>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfPerson.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(listOfPerson[position])
    }

    public class PersonViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
    private var tvPersonNameForRecycler = itemView.findViewById<TextView>(R.id.tvPersonNameForRecycler)
     //   private var ivPersonImageForRecycler = itemView.findViewById<ImageView>(R.id.ivPersonImageForRecycler
      //  )
        fun bind(person: Person){
            tvPersonNameForRecycler.text = person.name
        }
    }

}