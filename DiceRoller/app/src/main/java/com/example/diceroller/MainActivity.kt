/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Roll the dice when the app is started
        rollDice()

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice_1 = Dice(6)
        val diceRoll_1 = dice_1.roll()

        // Create another Dice object with 6 sides and roll it
        val dice_2 = Dice(6)
        val diceRoll_2 = dice_2.roll()

        // Find the the specific ImageView to update
        val diceImage_1: ImageView = findViewById(R.id.dice_1_image_view)
        val diceImage_2: ImageView = findViewById(R.id.dice_2_image_view)

        // Update the 1st ImageView with specific drawable when a certain number is rolled
        val drawableResource_1 = when (diceRoll_1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the appropriate dice image
        diceImage_1.setImageResource(drawableResource_1)

        // Set contentDescription to update with what is rolled
        diceImage_1.contentDescription = diceRoll_1.toString()

        // Update the 2nd ImageView with specific drawable when a certain number is rolled
        val drawableResource_2 = when (diceRoll_2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the appropriate dice image
        diceImage_2.setImageResource(drawableResource_2)

        // Set contentDescription to update with what is rolled
        diceImage_2.contentDescription = diceRoll_2.toString()
    }
}

