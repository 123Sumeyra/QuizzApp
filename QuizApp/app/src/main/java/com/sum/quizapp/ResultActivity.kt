package com.sum.quizapp

import android.content.Intent
import android.os.Binder
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
        val totalQuestion =intent.getStringExtra(Constant.TOTAL_QUESTİON)
        val correctAnswer =intent.getStringExtra(Constant.CORRECT_ANSWER)

        binding.textViewScore.text = "Your score is $correctAnswer out of $totalQuestion"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}