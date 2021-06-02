package com.example.medicare.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.medicare.R
import com.example.medicare.network.DiabetesData
import kotlin.math.round

class HomeFragment : Fragment() {

    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvDiabetesPrediction: TextView = view.findViewById(R.id.tv_diabetes_prediction)
        val tvOpinion: TextView = view.findViewById(R.id.tv_opinion)

        val diabetesData = DiabetesData(
            50,
            35,
        140,
            200,
            0,
            0,
            40
        )
        homeViewModel.getDiabetesPrediction(diabetesData)

        homeViewModel.diabetesPrediction.observe(viewLifecycleOwner, {
            tvDiabetesPrediction.text = "${it.diabetesPrediction.round(2)}%"
            tvOpinion.text = it.opinion
        })
    }
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}