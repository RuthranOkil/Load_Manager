package com.example.okilan.loadmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.loads.*


class findload : AppCompatActivity() {
    lateinit var ref :DatabaseReference
    lateinit var postlist :MutableList<store>

    @SuppressLint("ResourceType", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_findload)
        lateinit var listView: ListView

        postlist = mutableListOf()
        listView = findViewById<ListView>(R.id.list)
        ref = FirebaseDatabase.getInstance().getReference("details")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    postlist.clear()
                    for (pd in p0.children){
                        val det = pd.getValue(store::class.java)
                        postlist.add(det!!)
                    }
                    val adapter = LoadAdapter(this@findload,R.layout.loads ,postlist)
                    listView.adapter =adapter

                }
          }

        })




    }

    private fun <T> ArrayAdapter(valueEventListener: ValueEventListener, simple_list_item_1: Int, values: Array<T>) {

    }
}
