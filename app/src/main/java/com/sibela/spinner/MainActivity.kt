package com.sibela.spinner

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sibela.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val strings = arrayOf("Leonardo", "Nivia", "Tamara", "Maria")

        val spinner = binding.stringsSpinner

        adapter = StringAdapter(this, android.R.layout.simple_spinner_item, strings)
        spinner.adapter = adapter; // Set the custom adapter to the spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, p: Int, id: Long) {
                val string = adapter.getItem(p)
                Toast.makeText(this@MainActivity, string, Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", string)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                
            }
        }
    }
}