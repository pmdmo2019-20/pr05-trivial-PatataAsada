package es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import es.iessaladillo.pedrojoya.pr05_trivial.R

class GameWonFragment : Fragment() {

    companion object {
        fun newInstance() = GameWonFragment()
    }

    private lateinit var viewModel: GameWonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_won, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GameWonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
