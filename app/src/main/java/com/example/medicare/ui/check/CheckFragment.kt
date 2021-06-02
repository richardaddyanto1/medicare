package com.example.medicare.ui.check

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.medicare.R

class CheckFragment : Fragment() {

    private lateinit var checkViewModel: CheckViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        checkViewModel =
                ViewModelProvider(this).get(CheckViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_check, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        checkViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}