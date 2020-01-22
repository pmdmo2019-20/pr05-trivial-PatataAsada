package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setTitleFragment()
        setupObservers()
        viewModel = ViewModelProviders.of(this).get(MainViewmodel::class.java)
        /*
        TODO crear viewmodel para la actividad para observar cambios en los fragmentos y modificar
        el appbar conforme a ellos.
         */

    }

    private fun setupObservers() {
        //TODO observe viewmodel and change appbar.
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuSettings -> {
                navigateToSettings()
                true
            }
            R.id.mnuAbout -> {
                navigateToAbout()
                true
            }
            R.id.mnuRules -> {
                navigateToRules()
                true
            }

            else -> super.onOptionsItemSelected(item)

        }

    private fun navigateToRules() {
        //TODO change appbar and remove menu (funcion ejecutada por observador)
        val rulesFragment = RulesFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain,rulesFragment,rulesFragment.tag)
            .addToBackStack(rulesFragment.tag)
            .commit()
    }

    private fun navigateToAbout() {
        //TODO change appbar and remove menu
        val aboutFragment = AboutFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain,aboutFragment,aboutFragment.tag)
            .addToBackStack(aboutFragment.tag)
            .commit()
    }

    private fun navigateToSettings() {
        //TODO intent para actividad settings
    }


    private fun setTitleFragment() {
        val titleFragment = TitleFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain,titleFragment,titleFragment.tag)
            .addToBackStack(titleFragment.tag)
            .commit()
    }

}
