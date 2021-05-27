package com.example.recyclerViewExperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), ListContactDetails_Fragment.OnButtonListener,NameFragment.OnTextViewListener,EditNameFragment.OnEditTextViewListener {
     lateinit var ft: FragmentTransaction
     private lateinit var currentPerson: Person
     var listOfPerson = mutableListOf<Person>()
    lateinit var allImagesUrl: MutableList<String>

    companion object {
        var adapter = PhoneBookAdapter()
    }

    fun getUrl(){
      var url: URL = URL("https://picsum.photos/v2/list")
    var inputBaseUrl = BufferedReader(InputStreamReader(url.openStream()))
      var inputLineString: String = inputBaseUrl.readLine()
      inputBaseUrl.close()
        inputLineString = inputLineString.replace("[","").replace("]","").replace("{","").replace("\"","")
        allImagesUrl= inputLineString.split("}") as MutableList<String>
        var urlStartPosition : Int
        var imageCorrectUrl : String
        var i:Int = 0
        while ( i < allImagesUrl.size-1) {
            urlStartPosition = allImagesUrl[i].indexOf("download_url")
            allImagesUrl[i] = allImagesUrl[i].substring(urlStartPosition+13)
            Log.d("test", allImagesUrl[i])
            i++
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread {
            getUrl()
        }.join()
        initListOfPerson()
        adapter.listOfPersonFr = listOfPerson
        initFragmentListContact(savedInstanceState)




    }

    private fun initFragmentListContact(savedInstanceState: Bundle?) {
        Log.d("test","Call to initFragment")
        val lcDetails = ListContactDetails_Fragment()
        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.laMain, lcDetails)
        ft.commit()
    }

    override fun onButtonCLicked(person: Person) {
        currentPerson = person
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
        ft.addToBackStack(null)
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

    fun initListOfPerson() {
        for (i in 0..30) {
            listOfPerson.add(i, Person(UUID.randomUUID().toString(), "Name+$i", i,i,allImagesUrl[i]))
        }
    }
    override fun onEditTextViewCLicked(view: View) {
        var tvPersonName = NameFragment()
        Log.d("test","Click")
        var etPersonName: EditText = view.findViewById(R.id.etPersonName)
        etPersonName.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                 //   Toast.makeText(this@MainActivity,"Najata Enter",Toast.LENGTH_SHORT).show()
                    currentPerson.name = etPersonName.text.toString()
                    var personNameBundle = Bundle()
                    tvPersonName.arguments = personNameBundle
                    personNameBundle.putString("name",currentPerson.name)
                    Toast.makeText(this@MainActivity,currentPerson.name,Toast.LENGTH_SHORT).show()
                    ft = supportFragmentManager.beginTransaction()
                    ft.replace(R.id.contForPersonName,tvPersonName)
                    ft.commit()
                    return true
                }
                return false
            }
        })
    }
}