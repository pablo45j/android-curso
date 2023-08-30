package com.example.proyectofinal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.Texts as Texts


class ViewModelMain : ViewModel() {

    // Solo queremos que se pueda leer el contador
    val texts: LiveData<Texts> get() = _texts
    // mo nos interesa que se modifique por fuera del ViewModel
    private var _texts = MutableLiveData<Texts>(Texts(texto1="-", texto2="-"))

    fun compareTexts():String{

        if (_texts.value?.texto1==_texts.value?.texto2)  {
            return "LAS CADENAS SON IGUALES"
        }else{
            return "NO SON IGUALES LAS CADENAS"
        }
    }

    fun setTexts(texto1: String, texto2: String){
        _texts.value = Texts(texto1,texto2)
    }
}
