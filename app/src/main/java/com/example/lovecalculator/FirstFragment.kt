package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentFirstBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.LoveService
import com.example.lovecalculator.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel= LoveViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLove(
                    firstName = firstEt.text.toString(),
                    secondName = secondEt.text.toString()
                ).observe(viewLifecycleOwner, Observer {
                    Log.d("ololo", "initListener: $it")
                    findNavController().navigate(R.id.resultFragment, bundleOf("key" to it))
                })
            }
        }
    }

}