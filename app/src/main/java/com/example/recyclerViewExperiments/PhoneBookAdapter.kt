package com.example.recyclerViewExperiments

import android.app.Activity
import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.util.*
import kotlin.collections.ArrayList

class PhoneBookAdapter : RecyclerView.Adapter<PhoneBookAdapter.PersonViewHolder>(){
    var listOfPersonFr = emptyList<Person>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        return PersonViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listOfPersonFr.size
    }
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(listOfPersonFr[position])

    }
    public class PersonViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
    private var tvPersonNameForRecycler = itemView.findViewById<TextView>(R.id.tvPersonNameForRecycler)
        private var ivPersonAvatarForRecycler = itemView.findViewById<ImageView>(R.id.ivPersonAvatarForRecycler)
        fun bind(person: Person){
            tvPersonNameForRecycler.text = person.name
            Glide.with(itemView.context)
                .load(person.avatarUrl)
              //  .diskCacheStrategy(DiskCacheStrategy.ALL)
               //  .skipMemoryCache(true)
                .into(ivPersonAvatarForRecycler)
            Log.d("Request",Glide.with(itemView.context).load(person.avatarUrl).toString())
        }
    }

}