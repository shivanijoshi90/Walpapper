package com.example.walpapperapi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.walpapperapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var imageModel: ImageModel? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getWalpapper("flower")

       binding.imgsearch.setOnClickListener {
            var searchData = binding.edtSearch.text.toString()
            getWalpapper(searchData)
        }

    }

    fun setRv(){
        var adapter = WalpapperAdapter(this,imageModel!!.hits)
        var lm = GridLayoutManager(this,2,)
        binding.rvData.layoutManager = lm
        binding.rvData.adapter = adapter
    }


        fun getWalpapper(q: String) {
            var WalpapperInterface = WalpappreClient.getClient()?.create(WalpapperInterface::class.java)
            WalpapperInterface?.searchImageAPI("41626448-dc177bdab9c7d049689854042",q,"all,q,")
                ?.enqueue(object : Callback<ImageModel> {
                    override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                        if (response.code() == 200) {
                            imageModel = response.body()
                            setRv()
                        }
                    }

                    override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                        Log.e("TAG", "onFailure: ${t?.message}")
                    }


                })

    }
}