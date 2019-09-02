package com.example.mvrx_project.helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.example.mvrx_project.R
import com.example.mvrx_project.core.BaseFragment
import com.example.mvrx_project.core.BaseViewModel
import kotlinx.android.synthetic.main.hello_fragment.*


// State
data class HelloWorldState(val title: String = "Hello World!", @PersistState val count: Int = 0) :
    MvRxState

// ViewModel
class HelloWorldViewModel(initialState: HelloWorldState) :
    BaseViewModel<HelloWorldState>(initialState) {
    init {
        logStateChanges()
    }

    fun setText(value: String) {
        setState { copy(title = value) }
    }

    fun incrementCount() {
        setState { copy(count = count + 1) }
    }
}

// Fragment
class HelloWorldFragment : BaseFragment() {
    // Instantiate view model with state. This is local state for this fragment.
    private val myViewModel: HelloWorldViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hello_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        incrementButton.setOnClickListener {
            myViewModel.incrementCount()
        }
    }

    // Update UI.
    override fun invalidate() =
        // Setting value from state to view text manually.
        withState(myViewModel) { currentState ->
            textView.text = currentState.title + "\n" + currentState.count
        }


}
