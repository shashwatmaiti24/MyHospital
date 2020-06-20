package com.col740.myhospital

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.itemview.*

class ItemActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itemview)
//        val spinner: Spinner = this.findViewById(R.id.spinner)
        val id: String = intent.getStringExtra("id")
//        val slotarray = intent.getStringArrayExtra("slotarray")
//        for (r in slotarray) {
//            println(r)

//        val id = email.split(".").toTypedArray()[0]
        val database = FirebaseDatabase.getInstance("https://my-hospital-fce56.firebaseio.com/")
        val doctor =
            database.getReferenceFromUrl("https://my-hospital-fce56.firebaseio.com/Doctor/$id")
//        println("-------------------------------------------1")
        doctor.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
//                val info =
//                    arrayOf(
//                        "Name",
//                        "E-mail",
//                        "Specialisation",
//                        "Hospital",
//                        "Rating",
//                        "Base Charge",
//                        "Booking",
//                        "Booked By"
//                    )
//                for (i in info.indices) {
//                    println(data.child(info[i]).value.toString())
//                    println("__________________________")
//                    info[i] =
//                        data.child(info[i]).value.toString()
//                }
//                println(id)

                println("-------------------------------------------2")
                name.text = data.child("Name").value.toString()
//                println(data.child("Rating").value.toString())
//                println("_______________________________________________________")
                ratingBar.rating = data.child("Rating").value.toString().toFloat()
                specialization.text = data.child("Specialisation").value.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        book.setOnClickListener {
            val intent = Intent(this, Booking::class.java)
            intent.putExtra("doc", id)
            ContextCompat.startActivity(this, intent, null)
        }

//        println("-------------------------------------------3")
//
//
//
//        println("-------------------------------------------4")
//
//        println("-------------------------------------------6")

// Create an ArrayAdapter using the string array and a default spinner layout

//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_spinner_item, slotarray
//        )
//            // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        // Apply the adapter to the spinner
//
//        println("-------------------------------------------7")
//        spinner.adapter = adapter
//        println("-------------------------------------------8")
//        spinner.onItemSelectedListener = object:
//        AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                //To change body of created functions use File | Settings | File Templates.
//            }
//        }
    }
}
