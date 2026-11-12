package com.example.fehu

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import internet.fehu.post.FTPsomething
import internet.fehu.post.file_manip
import kotlinx.io.IOException
import java.io.File
import java.io.FileInputStream
import java.util.Objects.toString
import kotlin.concurrent.thread


//napsáno mnou
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val bP  = findViewById<Button>(R.id.buttonM)
        var t2 = findViewById<TextView>(R.id.textView)
        var i2 = findViewById<EditText>(R.id.editTextText)
        val BR = findViewById<Button>(R.id.buttonR)
        t2.setText("wait")
        val sentfile = openFileOutput("test.php", MODE_PRIVATE)


       BR?.setOnClickListener {
           file_manip.myChange(File(applicationContext.filesDir, "/test.php"), i2.getText().toString())
           thread(start = true) {
            FTPsomething.FUCKTHIS(
                "ftp.jankovska.cz",
                "jankovska.cz-www",
                "Tonikje_08",
                File(applicationContext.filesDir, "/test.php").toString()

            )
            }

        }



        /*BR?.setOnClickListener {
            t2.setText(File(applicationContext.filesDir, "/test.php").toString())
        }*/
        fun stringRequest() {
            val volleyQueue = Volley.newRequestQueue(this)
            var url = "https://jankovska.cz/test.php"
            val requestedString = StringRequest(
                url,
                { response ->
                    t2.text =  response
                },
                {error ->
                    Toast.makeText(this, "Some error occurred! message", Toast.LENGTH_LONG).show()
                    Log.e("MainActivity", "loadDogImage error: ${error.localizedMessage}")



                }
            )
            volleyQueue.add(requestedString)
            }
       bP?.setOnClickListener() { stringRequest() }

         }
    }





