package com.sum.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.sum.quizapp.databinding.ActivityQuizQuestionBinding


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityQuizQuestionBinding
    private var currentPosition:Int=1
    private var questionList:ArrayList<Question> ? = null
    private var selecedOption:Int=0
    private var correctNumber:Int=0
    private var username:String ?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        username = intent.getStringExtra(Constant.USER_NAME)


        questionList = Constant.getQuestion()
       // Log.i("Question Size:", "${questionList.size}")
        setQuestion()

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)



    }

    private fun setQuestion(){
        //currentPosition =1
        val question = questionList!![currentPosition-1]
        defaultOptionsView()

        if(currentPosition == questionList!!.size){
            binding.btnSubmit.text ="FINISH"
        }
        else{
            binding.btnSubmit.text ="SUBMIT"
        }

        binding.progressBar.progress =currentPosition
        binding.progressBar.max =questionList!!.size
        binding.tvProgress.text = "$currentPosition" + "/" + questionList!!.size

        binding.tvQuestion.text = question.question
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option_one ->{ selectedOptionView(binding.optionOne,1) }
            R.id.option_two ->{ selectedOptionView(binding.optionTwo,2) }
            R.id.option_three ->{ selectedOptionView(binding.optionThree,3) }
            R.id.option_four ->{ selectedOptionView(binding.optionFour,4) }
            R.id.btn_submit -> {
                if(selecedOption == 0){

                    currentPosition ++


                    when{
                        currentPosition <= questionList!!.size-> {setQuestion()}
                        else-> //{ Toast.makeText(this,"You have successfull completed",Toast.LENGTH_SHORT).show() }
                        {val intent =Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constant.USER_NAME,username)
                        intent.putExtra(Constant.CORRECT_ANSWER,correctNumber)
                        intent.putExtra(Constant.TOTAL_QUESTİON, questionList!!.size)
                        startActivity(intent)}
                    }


                } else{

                    val question = questionList?.get(currentPosition-1)
                    if(question!!.correctAnswer !=selecedOption){
                        answeView(selecedOption, R.drawable.wrong_option_one_border)
                       // answeView(question.correctAnswer,R.drawable.correct_option_one_border)

                    }else{
                        correctNumber++

                    }
                    answeView(question.correctAnswer,R.drawable.correct_option_one_border)

                }

                if(currentPosition == questionList?.size){
                    binding.btnSubmit.text ="FINISH"

                }else{
                    binding.btnSubmit.text = "Go To Next Question"
                }
                selecedOption =0
            }

        }


    }

    private fun answeView(answer:Int,drawableView:Int){
        when(answer){
            1 ->{binding.optionOne.background = ContextCompat.getDrawable(this,drawableView)}
            2 ->{binding.optionTwo.background =ContextCompat.getDrawable(this,drawableView)}
            3 ->{binding.optionThree.background =ContextCompat.getDrawable(this,drawableView)}
            4 ->{binding.optionFour.background = ContextCompat.getDrawable(this,drawableView)}
        }
    }

    private  fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionsView()
        selecedOption =selectedOptionNum

        tv.setTextColor(Color.parseColor("#555151"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
            this,R.drawable.selected_option_one_border)

    }
}