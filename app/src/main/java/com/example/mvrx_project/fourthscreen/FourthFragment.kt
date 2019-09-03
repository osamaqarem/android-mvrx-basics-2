package com.example.mvrx_project.fourthscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.airbnb.mvrx.existingViewModel
import com.example.mvrx_project.FormViewModel
import com.example.mvrx_project.R
import com.example.mvrx_project.core.BaseFragment
import kotlinx.android.synthetic.main.fourth_fragment.*

class FourthFragment : BaseFragment() {
    private val viewModel: FormViewModel by existingViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fourth_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonFour.setOnClickListener {
            it.findNavController().navigate(R.id.action_fourthFragment_to_firstFragment)
        }

    }

    override fun invalidate() {
    }
}