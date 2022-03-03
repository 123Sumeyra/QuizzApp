package com.sum.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.sum.quizapp.databinding.ActivityQuizQuestionBinding
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition:Int=1
    private var questionList:ArrayList<Question> ? = null
    private var selecedOption:Int=0


    private lateinit var binding:ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)


        questionList = Constant.getQuestion()
       // Log.i("Question Size:", "${questionList.size}")
        setQuestion()

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)



    }

    private fun setQuestion(){
        currentPosition =1
        val question =questionList!![currentPosition-1]
        defaultOptionsView()

        binding.progressBar.progress =currentPosition
        binding.tvProgress.text = "$currentPosition" + "/" + binding.progressBar.max

        binding.tvQuestion.text = question!!.question
        binding.image.setImageResource(question.image)
        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour




    }


    fun defaultOptionsView(){
        val options= ArrayList<TextView> ()
        options.add(0,binding.optionOne)
        options.add(1,binding.optionTwo)
        options.add(2,binding.optionThree)
        options.add(3,binding.optionFour)

        for(option in options)
        {
            option.setTextColor(Color.parseColor("#555151"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,R.drawable.defoult_option_one_border)

        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}