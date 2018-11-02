package com.example.okilan.loadmanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    val mAuth =FirebaseAuth.getInstance()
    lateinit var mDatabase :DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        button4.setOnClickListener(View.OnClickListener {
            val un = findViewById<EditText>(R.id.editText3)
            val email = findViewById<EditText>(R.id.editText4)
            val password = findViewById<EditText>(R.id.editText5)
            if (un.text.toString()!="" && email.text.toString()!="" &&password.text.toString()!=""){
                mAuth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener(this, OnCompleteListener {task ->
                    if (task.isSuccessful){
                        val user = mAuth.currentUser
                        val uid =user!!.uid.toString()
                        mDatabase.child(uid).child("name").setValue(un.text.toString())
                        Toast.makeText(this,"Successfully Registered",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,demo::class.java))
                    }
                    else{
                        Toast.makeText(this,"Error occured Try again",Toast.LENGTH_LONG).show()
                    }
                })
                mDatabase = FirebaseDatabase.getInstance().getReference("Names")

            }
            else
            {
                Toast.makeText(this,"Enter correct details",Toast.LENGTH_LONG).show()
            }
        })

    }
}
