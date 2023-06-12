package com.example.spinnerarrayadapter_edittext_timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinnerarrayadapter_edittext_timepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, countries)
        binding.spinner.adapter = adapter

        binding.button.setOnClickListener {
            val country = binding.spinner.selectedItem.toString()
            val hour = binding.timePicker.hour.toString()
            val min = binding.timePicker.minute.toString()
            val name = binding.editText.text.toString()
            val msg = "${country.uppercase()} - ${name.replaceFirstChar { it
                .uppercase() }} - $hour:$min"

            binding.textView.text = msg
        }
    }
}