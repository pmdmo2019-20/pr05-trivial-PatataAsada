package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.data.Database

class MainViewmodel(application: Application) : ViewModel() {
    var confirmBack: Boolean? = null
    var rematch: Boolean = false
    var maxQuestions: Int = 100
    private var _progress: MutableLiveData<Int> = MutableLiveData(1)
    val progress: LiveData<Int>
        get() = _progress
    private var _title: MutableLiveData<String> =
        MutableLiveData(application.getString(R.string.app_name))
    val title: LiveData<String>
        get() = _title
    private var _inTitle: MutableLiveData<Boolean> = MutableLiveData(true)
    val inTitle: LiveData<Boolean>
        get() = _inTitle
    private var _gameWon: MutableLiveData<Boolean> = MutableLiveData(false)
    val gameWon: LiveData<Boolean>
        get() = _gameWon
    private var _gameOver: MutableLiveData<Boolean> = MutableLiveData(false)
    val gameOver: LiveData<Boolean>
        get() = _gameOver

    val database = Database.queryQuestions()

    fun checkCompleted(): Boolean = progress.value!! > maxQuestions

    fun checkWrong(answer: String): Boolean {
        if (database[progress.value!!].right != answer) _gameOver.value = true
        return database[progress.value!!].right != answer
    }

    fun movingOutOfTitle() {
        _inTitle.value = false
    }

    fun movingToTitle() {
        _inTitle.value = true
    }

    fun changeTitle(string: String) {
        _title.value = string
    }

    fun getAnswers(): Array<String?> = database[progress.value?.minus(1)!!].getAnswers()

    fun resetGameData() {
        _progress.value = 1
        _gameOver.value = false
        _gameWon.value = false
        rematch = false
    }

    fun advanceProgress() {
        _progress.value = _progress.value?.plus(1)
    }
}
