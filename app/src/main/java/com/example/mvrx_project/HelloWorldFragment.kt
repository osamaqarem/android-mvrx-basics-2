package com.example.mvrx_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.withState
import com.example.mvrx_project.core.HelloWorldState
import kotlinx.android.synthetic.main.hello_fragment.*


// Fragment
class HelloWorldFragment : Fragment() {

    // instantiate view model with state
    private val viewModel = HelloWorldViewModel(HelloWorldState())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hello_fragment, container, false)
    }

    // withState allows accessing state
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
        withState(viewModel) { prevState -> textView.text = prevState.title }


}
