package com.odougle.navigation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.odougle.navigation.BottomActivity
import com.odougle.navigation.PagerActivity
import com.odougle.navigation.R
import com.odougle.navigation.TabsActivity
import com.odougle.navigation.databinding.FragmentFirstLevelBinding

class FirstLevelFragment : Fragment() {

    private var _binding : FragmentFirstLevelBinding? = null
    private val binding get() = _binding!!

    private var navigationType : String? = null
    private var actions = mutableMapOf<String, Class<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actions.put(getString(R.string.option_tab), TabsActivity::class.java)
        actions.put(getString(R.string.option_bottom), BottomActivity::class.java)
        actions.put(getString(R.string.option_pager), PagerActivity::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationType = arguments?.getString(EXTRA_TYPE)
        binding.button.setOnClickListener {
            val key = navigationType
            val clazz = actions[key]
            startActivity(Intent(activity, clazz))
        }
    }

    companion object{
        private const val EXTRA_TYPE = "tipoNavegacao"
        fun newInstance(type: String) : FirstLevelFragment{
            val params = Bundle()
            params.putString(EXTRA_TYPE, type)
            val f = FirstLevelFragment()
            f.arguments = params
            return f
        }
    }
}