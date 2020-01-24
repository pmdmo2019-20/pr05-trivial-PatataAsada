package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.R

class MainViewmodel(private val application: Application) : ViewModel() {
    var maxQuestions:Int = 0
    private var _progress:MutableLiveData<Int> = MutableLiveData(0)
    val progress: LiveData<Int>
        get() = _progress
    private var _title:MutableLiveData<String> = MutableLiveData(application.getString(R.string.title_activity_main))
    val title:LiveData<String>
        get() = _title
    private var _inTitle:MutableLiveData<Boolean> = MutableLiveData(true)
    val inTitle:LiveData<Boolean>
        get() = _inTitle

    fun clearData(){
        _progress.value = 0
        maxQuestions = 0
    }

    fun checkCompleted():Boolean = progress.value==maxQuestions
    fun checkWrong(answer:String):Boolean{
        return true
    }

    fun movingOutOfTitle(){
        _inTitle.value = false
    }

    fun movingToTitle(){
        _inTitle.value = true
    }

    fun changeTitle(string: String) {
        _title.value = string
    }
    // TODO: Implement the ViewModel
}
