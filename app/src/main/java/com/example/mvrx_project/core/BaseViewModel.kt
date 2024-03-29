package com.example.mvrx_project.core

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.example.mvrx_project.BuildConfig

// first S checks that the state is MvRxState and the second one ensures its the same type.
abstract class BaseViewModel<S : MvRxState>(initialState: S) :
    BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG)