package com.odougle.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class SecondLevelFragment : Fragment() {


    companion object{
        private const val EXTRA_TEXT = "texto"
        private const val EXTRA_BG_COLOR = "corBg"
        private const val EXTRA_TEXT_COLOR = "corTexto"
        fun newInstance(text:String,background:Int,textColor:Int):SecondLevelFragment{
            val params = Bundle()
            params.putString(EXTRA_TEXT, text)
            params.putInt(EXTRA_BG_COLOR,background)
            params.putInt(EXTRA_TEXT_COLOR, textColor)
            val slf = SecondLevelFragment()
            slf.arguments = params
            return slf
        }
    }
}