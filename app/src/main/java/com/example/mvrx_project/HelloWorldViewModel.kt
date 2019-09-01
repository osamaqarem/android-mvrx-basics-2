package com.example.mvrx_project

import com.example.mvrx_project.core.BaseViewModel
import com.example.mvrx_project.core.HelloWorldState

// ViewModel
class HelloWorldViewModel(initialState: HelloWorldState) :
    BaseViewModel<HelloWorldState>(initialState)
