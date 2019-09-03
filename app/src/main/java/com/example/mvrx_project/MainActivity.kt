package com.example.mvrx_project

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.example.mvrx_project.core.BaseViewModel


// State
data class FormState(val title: String = "Hello World!", @PersistState val count: Int = 0) :
    MvRxState

// ViewModel
class FormViewModel(initialState: FormState) :
    BaseViewModel<FormState>(initialState) {
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

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}