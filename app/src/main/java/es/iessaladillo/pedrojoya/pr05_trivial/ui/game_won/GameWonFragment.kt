package es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainViewmodel
import kotlinx.android.synthetic.main.fragment_game_won.*

class GameWonFragment : Fragment() {

    companion object {
        fun newInstance() = GameWonFragment()
    }

    private lateinit var viewmodel: MainViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_won, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = requireActivity().run {
            ViewModelProvider(this).get(MainViewmodel::class.java)
        }
        setupButtons()
    }

    private fun setupButtons() {
        btnNewMatch.setOnClickListener { rematch() }
    }

    private fun rematch() {
        viewmodel.resetGameData()
        viewmodel.rematch = true
        activity?.onBackPressed()
    }

}
