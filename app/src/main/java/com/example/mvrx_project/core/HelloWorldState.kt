package com.example.mvrx_project.core

import com.airbnb.mvrx.MvRxState

// State
data class HelloWorldState(val title: String = "Hello World!") : MvRxState
