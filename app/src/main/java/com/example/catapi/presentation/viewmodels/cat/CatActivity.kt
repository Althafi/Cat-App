package com.example.catapi.presentation.viewmodels.cat

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.catapi.R
import com.example.catapi.databinding.ActivityCatBinding
import com.example.catapi.di.Injection
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatActivity : AppCompatActivity(){
    private val viewModelCat : CatViewModel by viewModels{
        Injection.provideCatViewModel()
    }
    private var id : Int = 0
    private lateinit var binding: ActivityCatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent!=null){
            id = intent.getIntExtra("id",0)
            viewModelCat.getCatByIdValue(id.toString())
            CoroutineScope(Dispatchers.Main).launch {
                viewModelCat._catValue.collect {
                    when{
                        it.isLoading ->{
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        it.error.isNotBlank() ->{
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@CatActivity,"Unexpected Error", Toast.LENGTH_LONG).show()
                        }
                        it.catDetails.isNotEmpty()->{
                            binding.progressBar.visibility = View.GONE
                            it.catDetails.map { cat ->
                                val url = "${cat.imageUrl}/landscape_medium"
                                Picasso.get().load(url).placeholder(R.drawable.image1).into(binding.appCompatImageView)
                                binding.textView.text = cat.name
                                binding.textView2.text = cat.description
                                Log.d("description",cat.description)
                                binding.textView3.text = cat.temperament
                            }
                        }
                    }
                }
            }
        }
    }
}