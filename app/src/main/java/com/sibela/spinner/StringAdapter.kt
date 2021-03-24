package com.sibela.spinner

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class StringAdapter(context: Context, textViewResourceId: Int, values: Array<String>) :
    ArrayAdapter<String>(context, textViewResourceId, values) {

    private var strings: Array<String> = values

    override fun getCount() = strings.size

    override fun getItem(position: Int) = strings[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getDropDownView(position, convertView, parent) as TextView
        label.setTextColor(Color.BLACK)
        label.text = strings[position]
        return label
    }

    fun bindView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val label = super.getView(position, convertView, parent!!) as TextView
        label.setTextColor(Color.BLACK)
        label.text = strings[position]
        return label
    }
}