package com.sum.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sum.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity() {
    private lateinit var binding:ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)


        val questionList = Constant.getQuestion()
        Log.i("Question Size:", "${questionList.size}")

        val  currentPosition =1
        val question:Question ?= questionList[currentPosition-1]

        binding.progressBar.progress =currentPosition
        binding.tvProgress.text = "$currentPosition" + "/" + binding.progressBar.max

        binding.tvQuestion.text = question!!.question
        binding.image.setImageResource(question.image)
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour










    }
}