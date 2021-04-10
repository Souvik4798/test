package com.example.retrofitinsert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var url:String="http://192.168.56.1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        create1.setOnClickListener {

                process()
//            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
        }
    }

    private fun process(){
            var retrofit: Retrofit=Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var api:myapi=retrofit.create(myapi::class.java)
        var call:Call<model>?=api.getdata(fullname= fullname.text.toString(), email= email.text.toString(),
        address= address.text.toString(), password= password.text.toString())

        call?.enqueue(object : Callback<model> {
            override fun onResponse(call: Call<model>, response: Response<model>) {
                TODO("Not yet implemented")
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<model>, t: Throwable) {
                TODO("Not yet implemented")
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }


        }

        )




    }


}