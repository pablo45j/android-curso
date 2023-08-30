package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity

import com.example.proyectofinal.databinding.ActivityMainBinding
import com.example.proyectofinal.ViewModelMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModelMain: ViewModelMain by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelMain.texts.observe(this){
            println("Se actualizaron los textos. $it")


        }

        binding.compareButton.setOnClickListener {

            viewModelMain.setTexts(binding.texto1.text.toString() , binding.texto2.text.toString())
            //viewModelMain.updateTexts(R.id.texto1.toString() , R.id.texto2.toString())
            binding.result.text = viewModelMain.compareTexts()
        }
    }
}