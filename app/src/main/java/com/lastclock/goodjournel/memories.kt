package com.lastclock.goodjournel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class memories : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memories)
        val back=findViewById<Button>(R.id.back)
        val memo=findViewById<RelativeLayout>(R.id.memo_layout)
        val first_one_good=findViewById<TextView>(R.id.first_one_good_thing)
        val first_felt=findViewById<TextView>(R.id.first_felt)
        val second_one_good=findViewById<TextView>(R.id.second_one_good_thing)
        val second_felt=findViewById<TextView>(R.id.second_felt)
        val third_one_good=findViewById<TextView>(R.id.third_one_good_thing)
        val third_felt=findViewById<TextView>(R.id.third_felt)
        val today_date=findViewById<TextView>(R.id.today_date_memo)
        val firstno=findViewById<TextView>(R.id.firstno_)
        val secondno=findViewById<TextView>(R.id.secondno_)
        val thirdno=findViewById<TextView>(R.id.thirdno_)

        back.setOnClickListener {
            val int_back=Intent(this,MainActivity::class.java)
            startActivity(int_back)
        }


        val bundle=intent.extras
        if(bundle!=null){
            first_one_good.text=bundle.getString("first_one_message")
            first_felt.text=bundle.getString("first_one_felt")
            second_one_good.text=bundle.getString("second_one_message")
            second_felt.text=bundle.getString("second_one_felt")
            third_one_good.text=bundle.getString("third_one_message")
            third_felt.text=bundle.getString("third_one_felt")
        }



    }
}