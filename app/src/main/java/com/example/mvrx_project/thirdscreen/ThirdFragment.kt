package com.example.mvrx_project.thirdscreen

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
import kotlinx.android.synthetic.main.third_fragment.*

class ThirdFragment : BaseFragment() {


    private val viewModel: FormViewModel by existingViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonThree.setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }

        withState(viewModel) { currentState ->
            editTextThree.setText(currentState.textThree)
            editTextFour.setText(currentState.textFour)
        }

        with(editTextThree) {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setTextThree(text.toString())
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

        with(editTextFour) {
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    viewModel.setTextFour(text.toString())
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