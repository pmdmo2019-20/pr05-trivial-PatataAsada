package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TasksActivityViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            return MainViewmodel(application) as T
        }
        throw IllegalArgumentException("Must provide TaskActivityViewModel class")
    }

}