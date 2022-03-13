package com.sum.quizapp

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sum.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val username =intent.getStringExtra(Constant.USER_NAME)
        binding.textViewUsername.text =username
        val totalQuestion =intent.getIntExtra(Constant.TOTAL_QUESTİON,0)
        val correctAnswer =intent.getIntExtra(Constant.CORRECT_ANSWER,0)


        binding.textViewScore.text = "Your score is $correctAnswer out of $totalQuestion"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}