package es.iessaladillo.pedrojoya.pr05_trivial.ui.title

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewmodel
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {

    private lateinit var viewmodel: MainViewmodel
    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(requireContext())
    }

    companion object {
        fun newInstance() = TitleFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = requireActivity().run {
            ViewModelProvider(this).get(MainViewmodel::class.java)
        }
        setButton()
    }

    private fun setButton() {
        btnPlay.setOnClickListener { startGame() }
    }

    private fun startGame() {
        viewmodel.maxQuestions = settings.getInt("number_of_questions", 1)
        viewmodel.movingOutOfTitle()
        viewmodel.changeTitle(
            getString(
                R.string.game_question_title,
                viewmodel.progress.value,
                viewmodel.maxQuestions
            )
        )
        val gameFragment = GameFragment.newInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fcMain, gameFragment, tag)
            ?.addToBackStack(tag)
            ?.commit()
    }

}
