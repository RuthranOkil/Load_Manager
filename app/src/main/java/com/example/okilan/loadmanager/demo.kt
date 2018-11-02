package com.example.okilan.loadmanager

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_demo.*

class demo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
        button8.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,client1::class.java))
        })
        button9.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,findload::class.java))
        })
    }
}
