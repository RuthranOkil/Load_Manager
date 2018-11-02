package com.example.okilan.loadmanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        val un = findViewById<EditText>(R.id.editText)
        val password = findViewById<EditText>(R.id.editText2)
        button2.setOnClickListener(View.OnClickListener {
            if (un.text.toString()!="" && password.text.toString()!=""){
                mAuth.signInWithEmailAndPassword(un.text.toString(),password.text.toString()).addOnCompleteListener(this, OnCompleteListener {
                    task -> if (task.isSuccessful){
                    startActivity(Intent(this,demo::class.java))
                    Toast.makeText(this,"Successfully logged in",Toast.LENGTH_LONG).show()
                }
                    else{
                    Toast.makeText(this,"Email or password is wrong",Toast.LENGTH_LONG).show()
                }
                })

            }
            else{
                Toast.makeText(this,"Enter username and password",Toast.LENGTH_LONG).show()
            }
        })
        button3.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Register::class.java))
        })
    }
}
