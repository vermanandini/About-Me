package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Nandini Verma",)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName= myName
       // findViewById<Button>(R.id.button).setOnClickListener {
          //   addNickname(it)
       // }

         binding.button.setOnClickListener{
             addNickname(it)
         }
    }

    private fun addNickname(view:View){
       // val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

       //nicknameTextView.text = editText.text
       // editText.visibility = View.GONE
        //view.visibility = View.GONE
        //nicknameTextView.visibility= View.VISIBLE
        binding.apply {
            // binding.nicknameText.text = binding.nicknameEdit.text

            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.button.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        // hide the keyboard
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0 )
    }



}