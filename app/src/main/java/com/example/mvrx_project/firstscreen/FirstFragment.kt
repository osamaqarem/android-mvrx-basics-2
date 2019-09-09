package com.example.mvrx_project.firstscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.example.mvrx_project.FormViewModel
import com.example.mvrx_project.R
import com.example.mvrx_project.core.BaseFragment
import com.example.mvrx_project.data.networking.RequestsService
import kotlinx.android.synthetic.main.first_fragment.*


// Fragment
class FirstFragment : BaseFragment() {
    // Instantiate view model with state.
    private val viewModel: FormViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        incrementButton.setOnClickListener {
            viewModel.incrementCount()
        }

        RequestsService.getRepos()

        firstButton.setOnClickListener {
            it.findNavController().navigate(R.id.first_to_second)
        }
    }

    // Update UI.
    override fun invalidate() =
        // Setting value from state to view text manually.
        withState(viewModel) { currentState ->
            textView.text = currentState.count.toString()
        }


}
