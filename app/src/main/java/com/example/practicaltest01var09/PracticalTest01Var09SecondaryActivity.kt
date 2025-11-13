package com.example.practicaltest01var09

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.result.contract.ActivityResultContracts


class PracticalTest01Var09SecondaryActivity : AppCompatActivity() {
    private lateinit var return_button: Button
    private var sum: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var09_secondary)

        var terms_string = intent.getStringExtra("TERMS")
        var terms_vec = terms_string?.split(" + ")

        if (terms_vec != null) {
            for (term in terms_vec){
                sum += term.toInt();
                Log.w("SUMA SECOND","Suma ${sum}")
            }
        }


//        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
////            if (result.resultCode == Activity.RESULT_OK) {
////                Toast.makeText(this, "The activity returned with result OK", Toast.LENGTH_LONG).show()
////            }
////            else if (result.resultCode == Activity.RESULT_CANCELED) {
////                Toast.makeText(this, "The activity returned with result CANCELED", Toast.LENGTH_LONG).show()
////            }
//        }


        val navigateToFirstActivityButton = findViewById<Button>(R.id.return_button)
        navigateToFirstActivityButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("SUM", Integer.valueOf(sum))
//            activityResultsLauncher.launch(intent)
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}