package com.thefuntasty.mvvmsample.ui.base

import androidx.databinding.ViewDataBinding
import com.thefuntasty.mvvm.BR
import com.thefuntasty.mvvm.BaseBindingViewModelFragment
import com.thefuntasty.mvvm.BaseViewModel
import com.thefuntasty.mvvm.ViewState

abstract class BaseFragment<VM : BaseViewModel<VS>, VS : ViewState, B : ViewDataBinding> :
    BaseBindingViewModelFragment<VM, VS, B>() {

    override fun getBRViewVariableId() = BR.view

    override fun getBRViewModelVariableId() = BR.viewModel

    override fun getBRViewStateVariableId() = BR.viewState
}
