package com.example.mvrx_project

import android.os.Bundle
import com.airbnb.mvrx.BaseMvRxActivity
import com.airbnb.mvrx.MvRxState
import com.example.mvrx_project.core.BaseViewModel


// State
data class FormState(
    val count: Int = 0,
    val textOne: String = "",
    val textTwo: String = "",
    val textThree: String = "",
    val textFour: String = "",
    val textFive: String = "",
    val textSix: String = ""
) :
    MvRxState

// ViewModel
class FormViewModel(initialState: FormState) :
    BaseViewModel<FormState>(initialState) {
    init {
        logStateChanges()
    }

    fun incrementCount() {
        setState { copy(count = count + 1) }
    }

    fun setTextOne(value: String) {
        setState { copy(textOne = value) }
    }


    fun setTextTwo(value: String) {
        setState { copy(textTwo = value) }
    }


    fun setTextThree(value: String) {
        setState { copy(textThree = value) }
    }

    fun setTextFour(value: String) {
        setState { copy(textFour = value) }
    }

    fun setTextFive(value: String) {
        setState { copy(textFive = value) }
    }

    fun setTextSix(value: String) {
        setState { copy(textSix = value) }
    }
}

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}