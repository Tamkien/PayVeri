package com.kienct.payveri.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kienct.payveri.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnSubmit: Button = binding.btnSubmit
        binding.apply {
        btnSubmit.setOnClickListener {
            saveProfile(etBankText.text.toString(), etPrefix.text.toString(), etToken.text.toString(), etUrl.text.toString())
        }
        }
        return root
    }

    private fun saveProfile(bankText: String, prefix: String, token: String, url: String) {
        // Save the profile to the cache
        val sharedPref = activity?.getPreferences(0) ?: return
        with (sharedPref.edit()) {
            putString("bankText", bankText)
            putString("prefix", prefix)
            putString("token", token)
            putString("url", url)
            apply()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}