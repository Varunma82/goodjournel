package com.lastclock.goodjournel

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val memo=findViewById<Button>(R.id.memo)
        val canthink=findViewById<Button>(R.id.can_think)
        val first_one_good=findViewById<EditText>(R.id.first_one_good_thing)
        val first_felt=findViewById<EditText>(R.id.first_felt)
        val second_one_good=findViewById<EditText>(R.id.second_one_good_thing)
        val second_felt=findViewById<EditText>(R.id.second_felt)
        val third_one_good=findViewById<EditText>(R.id.third_one_good_thing)
        val third_felt=findViewById<EditText>(R.id.third_felt)
        val save_button=findViewById<Button>(R.id.save)
        val share_your_app=findViewById<Button>(R.id.share_your_app)
        val today_date=findViewById<TextView>(R.id.today_date)
        val firstno=findViewById<TextView>(R.id.firstno_)
        val secondno=findViewById<TextView>(R.id.secondno_)
        val thirdno=findViewById<TextView>(R.id.thirdno_)


        //memo activity connectivity
        memo.setOnClickListener {
            val intent=Intent(this,memories::class.java)
            startActivity(intent)
        }

        //can't think
        canthink.setOnClickListener {
            val canthink_a=Intent(Intent.ACTION_VIEW, Uri.parse("https://frjwgwzqqotcxoamea.wixsite.com/goodjounrl"))
            startActivity(canthink_a)
        }


        //share this application
        share_your_app.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val app = applicationContext.applicationInfo
                val filePath = app.publicSourceDir
                val sharingIntent = Intent(Intent.ACTION_SEND)
                val uri = Uri.parse(filePath)
                sharingIntent.type = "*/*"
                sharingIntent.putExtra(Intent.EXTRA_STREAM, uri)
                sharingIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Click to blue link and download the app. https://drive.google.com/open?id=10Nc5BoYn4NZ_O8ae32UVQwyzdCzFxNy"
                )
                startActivity(Intent.createChooser(sharingIntent, "Share this app"))
            }
        })


        //save button
        save_button.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("first_one_message",first_one_good.text.toString())
            bundle.putString("first_one_felt",first_felt.text.toString())
            bundle.putString("second_one_message",second_one_good.text.toString())
            bundle.putString("second_one_felt",second_felt.text.toString())
            bundle.putString("third_one_message",third_one_good.text.toString())
            bundle.putString("third_one_felt",third_felt.text.toString())

            val intent_send=Intent(this,memories::class.java)
            intent_send.putExtras(bundle)
            startActivity(intent_send)
        }


    }
}