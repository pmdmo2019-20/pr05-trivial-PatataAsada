package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewmodel
import kotlinx.android.synthetic.main.fragment_game.*


class GameFragment : Fragment() {

    companion object {
        fun newInstance() =
            GameFragment()
    }

    private lateinit var viewmodel: MainViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = requireActivity().run {
            ViewModelProvider(this).get(MainViewmodel::class.java)
        }
        changeQuestionAndAnswers()
        setupButtons()
    }

    private fun setupButtons() {
        btnSubmit.setOnClickListener { checkAnswer() }
    }

    private fun checkAnswer() {
        if(rgAnswers.checkedRadioButtonId != -1){
            val radioButtonID: Int = rgAnswers.checkedRadioButtonId
            val radioButton: View = rgAnswers.findViewById(radioButtonID)
            val idx: Int = rgAnswers.indexOfChild(radioButton)

            val r = rgAnswers.getChildAt(idx) as RadioButton
            val selectedtext = r.text.toString()
            if(!viewmodel.checkWrong(selectedtext)) {
                nextQuestion()
            }
        }
    }

    private fun nextQuestion() {
        viewmodel.advanceProgress()
        changeQuestionAndAnswers()
    }

    private fun changeQuestionAndAnswers() {
        lblQuestion.text = viewmodel.database[viewmodel.progress.value?.minus(1)!!].question
        var answers = viewmodel.getAnswers()

        rbOption1.text = answers[0]
        rbOption2.text = answers[1]
        rdOption3.text = answers[2]
        rdOption4.text = answers[3]
    }

}
