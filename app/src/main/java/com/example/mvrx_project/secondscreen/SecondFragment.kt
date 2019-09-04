package com.example.mvrx_project.secondscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.airbnb.mvrx.existingViewModel
import com.airbnb.mvrx.withState
import com.example.mvrx_project.FormViewModel
import com.example.mvrx_project.R
import com.example.mvrx_project.core.BaseFragment
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : BaseFragment() {

    private val viewModel: FormViewModel by existingViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.second_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonTwo.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        withState(viewModel) { currentState ->
            editTextOne.setText(currentState.textOne)
            editTextTwo.setText(currentState.textTwo)
        }

        with(editTextOne) {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setTextOne(text.toString())
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }

        with(editTextTwo) {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setTextTwo(text.toString())
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }
    }

    override fun invalidate() {
    }
}