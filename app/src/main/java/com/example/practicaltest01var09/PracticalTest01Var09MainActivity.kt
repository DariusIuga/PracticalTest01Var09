package com.example.practicaltest01var09

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var09MainActivity : AppCompatActivity() {
    private lateinit var add_button: Button
    private lateinit var compute_button: Button
    private lateinit var next_term_text: EditText
    private lateinit var all_terms_text: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var09_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        add_button = findViewById(R.id.add_button)
        compute_button = findViewById(R.id.compute_button)
        next_term_text = findViewById(R.id.next_term_text)
        all_terms_text = findViewById(R.id.all_terms_text)

        next_term_text.setText("")
        all_terms_text.setText("")


        add_button.setOnClickListener {
            var number = next_term_text.text.toString().toInt()
            var current_text = all_terms_text.text.toString()
            if(current_text.length == 0){
                all_terms_text.setText(current_text + number.toString())
            }
            else{
                all_terms_text.setText(current_text + " + " + number.toString())
            }

            next_term_text.setText("")
        }
    }
}