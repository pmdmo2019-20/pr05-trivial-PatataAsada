package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setMenu()
        setTitleFragment()
        /*
        TODO crear viewmodel para la actividad para observar cambios en los fragmentos y modificar
        el appbar conforme a ellos.
         */

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun navigateToAbout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun navigateToSettings() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setMenu() {

    }


    private fun setTitleFragment() {
        val titleFragment = TitleFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain,titleFragment,titleFragment.tag)
            .addToBackStack(titleFragment.tag)
            .commit()
    }

}
