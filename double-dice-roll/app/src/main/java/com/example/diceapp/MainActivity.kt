package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a 6-sided dice and
 * view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // make the rollDice function run when the user clicks the roll button
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // Create a Dice object with 6 sides and roll it
        val diceOne = Dice(6)
        val diceOneRoll = diceOne.roll()

        // Create another Dice object with 6 sides and roll it
        val diceTwo = Dice(6)
        val diceTwoRoll = diceTwo.roll()

        // Display a short message to let the user know the click has been registered
        val toast = Toast.makeText(this, "Two dice rolled!", Toast.LENGTH_SHORT)
        toast.show()

        // Update the screen with the the first dice roll result
        val resultTextView1: TextView = findViewById(R.id.textView1)
        resultTextView1.text = diceOneRoll.toString()

        // Update the screen with the second dice roll result
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceTwoRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    // roll the dice and return a random integer value between 1 and number of sides
    fun roll(): Int {
        return (1..numSides).random()
    }
}