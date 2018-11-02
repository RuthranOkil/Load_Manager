package com.example.okilan.loadmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LoadAdapter(val mCtx: Context,val layoutResId: Int,val loaddet :List<store>)
    :ArrayAdapter<store>(mCtx,layoutResId,loaddet){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx);
        val view: View =layoutInflater.inflate(layoutResId,null)
        val t1 =view.findViewById<TextView>(R.id.textView5)
        val t2 = view.findViewById<TextView>(R.id.textView6)
        val t3 = view.findViewById<TextView>(R.id.textView7)
        val t4 = view.findViewById<TextView>(R.id.textView8)
        val load =loaddet[position]
        t1.text="Load:"+load.d1.toString()
        t2.text="Source:"+load.d2.toString()
        t3.text="Desination:"+load.d3.toString()
        t4.text="Contact:"+load.d4.toString()
        return view;

    }
}