package com.thefuntasty.mvvm

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.thefuntasty.mvvm.event.Event
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
abstract class ViewModelActivity<VM : BaseViewModel<VS>, VS : ViewState> : AppCompatActivity(), ViewModelCreator<VM> {

    abstract val layoutResId: Int

    lateinit var viewModel: VM

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getVM(viewModelClass).apply {
            lifecycle.addObserver(this)
        }
    }

    private fun getVM(vmClazz: KClass<VM>): VM {
        return ViewModelProviders.of(this, viewModelFactory).get(vmClazz.java)
    }

    fun <E : Event<VS>> FragmentActivity.observeEvent(event: KClass<out E>, observer: (E) -> Unit) {
        viewModel.observeEvent(this, event, observer as (Event<VS>) -> Unit)
    }
}
