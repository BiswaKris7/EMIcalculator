package com.example.emi


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_summary)

        ////// gets the emi value
        val emi = intent.getDoubleExtra("EMI_RESULT", 0.0)

        //// Get reference to the textvieww
        val tvEMISummary: TextView = findViewById(R.id.tvEMISummary)
        tvEMISummary.text = String.format("Your Monthly EMI is: %.2f", emi)

        val btnBack: Button = findViewById(R.id.btnBack)
        ///// back button to take to the main page
        ///////////
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}