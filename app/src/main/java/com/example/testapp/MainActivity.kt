package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.testapp.databinding.ActivityMainBinding

class MainViewModel : ViewModel(){
    var counter:Int = 0
}

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(ARG_COUNTER, mainViewModel.counter)
        super.onSaveInstanceState(outState)

    }
    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
       mainViewModel.counter = savedInstanceState.getInt(ARG_COUNTER)
        updateText()
    }
    private fun initViews() {
        binding.btnClick.setOnClickListener{
            mainViewModel.counter++
            updateText()
        }
    }
    private fun updateText(){
        binding.tvCounter.text = "${mainViewModel.counter} Clicks"
    }
    companion object{
        private const val ARG_COUNTER = "ARG_COUNTER"
    }
}