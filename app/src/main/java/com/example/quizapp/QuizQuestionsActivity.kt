package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding: ActivityQuizQuestionsBinding
    private var mCurrentPosition :Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOption : Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName : String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserName = intent.getStringExtra(Constants.USER_NAME).toString()
        //get the list of questions from Constant getQuestion method
        mQuestionList = Constants.getQuestions()
        //Call the set Question method
        setQuestion()
        //set the clickListeners
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSumbit.setOnClickListener(this)

    }
    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        //Set the default option view method
        defaultOptionView()

        if (mQuestionList?.size == mCurrentPosition){
            binding.btnSumbit.text = "FINISH"
        }else{
            binding.btnSumbit.text = "SUBMIT"
        }
        // Set the progress Bar
        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" + "/" + binding.progressBar.max
        //Set all the textView with appropriate questions and options
        binding.tvQuestion.text = question.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border_bg)
            option.typeface = Typeface.DEFAULT
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_optionTwo ->{
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_optionThree ->{
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_optionFour ->{
                selectedOptionView(binding.tvOptionFour,4)
            }
            R.id.btn_sumbit ->{
                if (mSelectedOption == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (mSelectedOption != question!!.correctAnswer){
                        answerView(mSelectedOption,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionList?.size){
                        binding.btnSumbit.text = "FINISH"
                    }else{
                        binding.btnSumbit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOption = 0
                }

            }
        }
    }
    private fun answerView(answer : Int , drawableView : Int){
        when(answer){
            1 ->{
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            2 ->{
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            3 ->{
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
            4 ->{
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this,drawableView)
            }
        }

    }
    private fun selectedOptionView(tv :TextView,selectedOptionNum: Int){
        mSelectedOption = selectedOptionNum
        defaultOptionView()
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_bg)
//        tv.typeface = Typeface.DEFAULT
        tv.setTypeface(tv.typeface,Typeface.BOLD)

    }
}