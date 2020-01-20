package es.iessaladillo.pedrojoya.pr05_trivial.ui.rules

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import es.iessaladillo.pedrojoya.pr05_trivial.R

class RulesFragment : Fragment() {

    companion object {
        fun newInstance() = RulesFragment()
    }

    private lateinit var viewModel: RulesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RulesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
