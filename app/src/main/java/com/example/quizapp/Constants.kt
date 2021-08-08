package com.example.quizapp

object Constants{
    const val USER_NAME = "user-name"
    const val CORRECT_ANSWERS = "correct-answer"
    const val TOTAL_QUESTIONS = "total-questions"

    fun getQuestions() : ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val questionOne = Question(1,"What country does this flag belong to?"
        ,R.drawable.ic_flag_of_argentina,"Argentina","Australia","India","America",
            1)

        questionsList.add(questionOne)

        val questionTwo = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_australia,"Brazil","Australia","Dubai","Britain",
            2)

        questionsList.add(questionTwo)

        val questionThree = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_belgium,"Austria","Belgium","Sri Lanka","kuwait",
            2)

        questionsList.add(questionThree)

        val questionFour = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_brazil,"Brazil","China","Russia","Canada",
            1)

        questionsList.add(questionFour)

        val questionFive = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_denmark,"Argentina","Australia","Denmark","America",
            3)

        questionsList.add(questionFive)

        val questionSix = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_fiji,"Africa","Canada","Russia","Fiji",
            4)

        questionsList.add(questionSix)

        val questionSeven = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_germany,"Germany","Australia","New Zealand","Britain",
            1)

        questionsList.add(questionSeven)

        val questionEight = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_india,"India","Australia","Denmark","Nepal",
            1)

        questionsList.add(questionEight)

        val questionNine = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_kuwait,"Saudi Arabia","Australia","Kuwait","America",
            3)

        questionsList.add(questionNine)

        val questionTen = Question(1,"What country does this flag belong to?"
            ,R.drawable.ic_flag_of_new_zealand,"China","New Zealand","Israel","Australia",
            2)

        questionsList.add(questionTen)


        return questionsList
    }

}