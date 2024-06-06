package edu.qc.seclass.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class TipCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val check = findViewById<EditText>(R.id.checkAmountValue)
        val people = findViewById<EditText>(R.id.partySizeValue)


        val tip = findViewById<TextView>(R.id.fifteenPercentTipValue)
        val total = findViewById<TextView>(R.id.fifteenPercentTotalValue)


        val tip2 = findViewById<TextView>(R.id.twentyPercentTipValue)
        val total2 = findViewById<TextView>(R.id.twentyPercentTotalValue)


        val tip3 = findViewById<TextView>(R.id.twentyfivePercentTipValue)
        val total3 = findViewById<TextView>(R.id.twentyfivePercentTotalValue)


        val calButton = findViewById<Button>(R.id.buttonCompute)
        calButton.setOnClickListener {
            val valid1 = check.text.toString()
            val valid2 = people.text.toString()
            if (valid1.isNotEmpty() && valid2.isNotEmpty() && valid2.trim() != "0") {
                val n1 = check.text.toString().toDouble()
                val n2 = people.text.toString().toDouble()

                val result = n1 / n2


                tip.text = (result * .15).roundToInt().toString()
                total.text = (result + result * .15).roundToInt().toString()


                tip2.text = (result * .20).roundToInt().toString()
                total2.text = (result + result * .20).roundToInt().toString()


                tip3.text = (result * .25).roundToInt().toString()
                total3.text = (result + result * .25).roundToInt().toString()
            }
            else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            }


        }
    }
}