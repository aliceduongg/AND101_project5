package com.example.my_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    var astronomyImageURL = " "
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.getPhotoButton)
        val imageView = findViewById<ImageView>(R.id.astronomyPhoto)

        button.setOnClickListener {
            getAstronomyPhoto(button, imageView)
        }
         fun getAstronomyPhoto() {
            val client = AsyncHttpClient()

            client["https://api.nasa.gov/EPIC/api/natural?api_key=DEMO_KEY", object :
                JsonHttpResponseHandler() {

                override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                    // Access a JSON object response with `json.jsonObject`
                    Log.d("DEBUG OBJECT", json.jsonObject.toString())

                    val astronomyPhotoURL = json.jsonObject.getString("url")
                    //use image loading library
                }

                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    response: String,
                    throwable: Throwable?
                ) {
                    Log.d("PHOTO FAIL", response)
                }
            }]

        }

    }

    private fun getAstronomyPhoto(button: Button?, imageView: Any) {
        if (button != null) {
            button.setOnClickListener {
                getAstronomyPhoto()

                Glide.with(this)
                    .load(astronomyImageURL)
                    .fitCenter()
                    .into(imageView as ImageView)
            }
        }
    }

    private fun getAstronomyPhoto() {
        TODO("Not yet implemented")
    }

}


