package com.example.okilan.loadmanager

import android.content.ComponentCallbacks2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_client1.*

class client1 : AppCompatActivity() {
    lateinit var mDatabase :DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client1)
        mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        button7.setOnClickListener(View.OnClickListener {
            val load =findViewById<EditText>(R.id.editText7)
            val src =findViewById<EditText>(R.id.editText8)
            val dest =findViewById<EditText>(R.id.editText9)
            val cnt =findViewById<EditText>(R.id.editText10)

            if (load.text.toString()!="" &&src.text.toString()!="" &&dest.text.toString()!="" &&cnt.text.toString()!="" ){
                val d1 = load.text.toString()
                val d2 = src.text.toString()
                val d3 = dest.text.toString()
                val d4 = cnt.text.toString()
                val ref = FirebaseDatabase.getInstance().getReference("details")
                val id =ref.push().key
                val det = store(id,d1,d2,d3,d4)
                ref.child(id).setValue(det).addOnCompleteListener(){
                    Toast.makeText(this,"Successfully updated to the Timeline",Toast.LENGTH_LONG).show()
                    load.text= null
                    src.text = null
                    dest.text = null
                    cnt.text = null
                }

            }else{
                Toast.makeText(this,"Enter Correct Details", Toast.LENGTH_LONG).show()
            }
        })
        button6.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,findload::class.java))
        })

    }

}
