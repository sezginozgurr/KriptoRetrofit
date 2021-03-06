package com.example.kriptoretrofit.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kriptoretrofit.R
import com.example.kriptoretrofit.adapter.RecycleAdapter
import com.example.kriptoretrofit.model.CryptoModel
import com.example.kriptoretrofit.service.CryptoAPI
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels: ArrayList<CryptoModel>? = null
    private var recyclerAdapter: RecycleAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Network()
    }

    private fun Network() {

        val retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(CryptoAPI::class.java)
        val call = service.getData()

        call.enqueue(object : Callback<List<CryptoModel>> {

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        it
                        recyclerAdapter = RecycleAdapter(it)
                        recycle.adapter = recyclerAdapter

                    }
                }
            }

        })
    }
}

//5babfaef5f80a1ab96753e670b81b8da
//https://api.nomics.com/v1/prices?key=5babfaef5f80a1ab96753e670b81b8da