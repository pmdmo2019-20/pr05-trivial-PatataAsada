package es.iessaladillo.pedrojoya.pr05_trivial.ui.title

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment() {

    companion object {
        fun newInstance() = TitleFragment()
    }

    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TitleViewModel::class.java)
        // TODO: Use the ViewModel
        setButton()
    }
    private fun setButton() {
        btnPlay.setOnClickListener { startGame() }
    }

    private fun startGame() {
        //TODO mover a fragmento game con la configuración de settings activity.
        //Lo mejor supongo que será crear un único mainViewmodel y manejar los datos por él.
        val gameFragment = GameFragment.newInstance()
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fcMain,gameFragment, tag)
            ?.addToBackStack(tag)
            ?.commit()
    }

}
