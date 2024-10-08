package com.example.thirdpracremaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class DisplayFragment1 : Fragment() {
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val textView: TextView = view.findViewById(R.id.textView)

        viewModel.displayedData.observe(viewLifecycleOwner, Observer { data ->
            textView.text = data
        })

        // Загружаем данные из файла (если нужно)
        viewModel.loadDataFromFile(requireContext(), "data.txt")
    }
}
