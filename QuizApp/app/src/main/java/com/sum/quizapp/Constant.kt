package com.sum.quizapp

object Constant {
    fun getQuestion():ArrayList<Question> {
        var questionList =ArrayList<Question>()

        var question1 = Question(
            1,
            "what country does this  flag belong to ?",
            R.drawable.arjantina_flag,
            "Canada",
            "İndia",
            "Turkey",
            "Arjantina",
            1
        )

        var question2 = Question(
            1,
            "what country does this  flag belong to ?",
            R.drawable.canada_flag,
            "Canada",
            "İndia",
            "Turkey",
            "Arjantina",
            1
        )

        var question3 = Question(
            1,
            "what country does this  flag belong to ?",
            R.drawable.turkish_flag,
            "Canada",
            "İndia",
            "Turkey",
            "Arjantina",
            1
        )

        var question4 = Question(
            1,
            "what country does this  flag belong to ?",
            R.drawable.india_flag,
            "Canada",
            "İndia",
            "Turkey",
            "Arjantina",
            1
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)

        return questionList
    }
}