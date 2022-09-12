package com.example.coinflipkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onTap()
    }

    private fun onTap(){
        val coin = findViewById<ImageView>(R.id.coin)
        coin.setOnClickListener {
            val result = (1..2).random()
            if(result == 1){
                flipAnimation(R.drawable.usd_head, "Heads")
            } else {
                flipAnimation(R.drawable.usd_tail, "Tails")
            }
        }
    }
    fun flipAnimation(resultImage: Int, resultText: String){

        val coinImage = findViewById<ImageView>(R.id.coin)
        coinImage.animate().apply {
            duration = 1000
            rotationYBy(1800f)
            coinImage.isClickable = false

        }.withEndAction {
            coinImage.setImageResource(resultImage)
            Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show()
            coinImage.isClickable = true
        }
    }
}