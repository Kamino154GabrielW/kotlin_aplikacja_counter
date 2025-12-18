package com.example.cliker

import android.os.Bundle
import android.widget.TextView // <-- 1. Dodaj import dla TextView
import android.widget.Button  // <-- 1. Dodaj import dla Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    var numer: Int = 0


    private lateinit var licznikTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)




        licznikTextView = findViewById(R.id.licznikTextView)


        val przyciskPlus: Button = findViewById(R.id.przyciskPlus)
        val przyciskMinus: Button = findViewById(R.id.przyciskMinus)
        val przyciskReset: Button = findViewById(R.id.przyciskReset)


        przyciskPlus.setOnClickListener {
            test()
            updateUI()
        }


        przyciskMinus.setOnClickListener {
            decrise()
            updateUI()
        }


        przyciskReset.setOnClickListener {
            reset()
            updateUI()
        }


        updateUI()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.header)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    private fun updateUI() {

        licznikTextView.text = numer.toString()
    }



    fun test(){
        numer += 1
    }
    fun reset(){
        numer = 0
    }
    fun decrise(){
        numer -= 1
    }
}