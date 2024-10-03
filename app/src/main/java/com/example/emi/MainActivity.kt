package com.example.emi


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etPrincipal: EditText = findViewById(R.id.etPrincipal)

        val etInterestRate: EditText = findViewById(R.id.etInterestRate)
        val etTenure: EditText = findViewById(R.id.etTenure)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)

        btnCalculate.setOnClickListener {

            val princi = etPrincipal.text.toString().toDoubleOrNull() ?: 0.0

            val annualIntRate = etInterestRate.text.toString().toDoubleOrNull() ?: 0.0

            val loanYears = etTenure.text.toString().toIntOrNull() ?: 0

            // Calculates the monthly interest rate //////////////////////
            val montlyIntRate = (annualIntRate / 12) / 100
            ////// Calculates the Loan tenure in month //////////////
            val tenureMonths = loanYears * 12



            //// EMI Calculation ///////////////////////////
            val emi = if (montlyIntRate != 0.0 && tenureMonths != 0) {

                val emiValue = (princi * montlyIntRate * (1 + montlyIntRate).pow(tenureMonths)) /
                        ((1 + montlyIntRate).pow(tenureMonths) - 1)
                emiValue

            } else {

                0.0
            }

            ////// Create intent and displays EMI value/////
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("EMI_RESULT", emi)
            startActivity(intent)
        }
    }
}
