package es.iessaladillo.pedrojoya.pr05_trivial.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_over.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game_won.GameWonFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.settings.SettingsActivity
import es.iessaladillo.pedrojoya.pr05_trivial.ui.title.TitleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewmodel by viewModels {
        TasksActivityViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setTitleFragment()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.title.observe(this) { changeToolbarTitle(false) }
        viewModel.inTitle.observe(this) { changeToolbar() }
        viewModel.progress.observe(this) { changeToolbarTitle(true) }
        viewModel.gameOver.observe(this) { finishedGame() }
        viewModel.gameWon.observe(this) { finishedGame() }
    }

    private fun finishedGame() {
        if (viewModel.gameWon.value!!) {
            moveToGameWon()
        }
        if (viewModel.gameOver.value!!) {
            moveToGameOver()
        }
    }

    private fun moveToGameOver() {
        val gameOverFragment = GameOverFragment.newInstance()
        changeTitle(getString(R.string.app_name))
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, gameOverFragment, gameOverFragment.tag)
            .addToBackStack(gameOverFragment.tag)
            .commit()
    }

    private fun moveToGameWon() {
        val gameWonFragment = GameWonFragment.newInstance()
        changeTitle(getString(R.string.app_name))
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, gameWonFragment, gameWonFragment.tag)
            .addToBackStack(gameWonFragment.tag)
            .commit()
    }

    private fun changeToolbar() {
        if (!viewModel.inTitle.value!!) {
            toolbar.menu.clear()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        } else {
            onCreateOptionsMenu(toolbar.menu)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        viewModel.movingToTitle()
        toolbar.title = getString(R.string.app_name)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun changeToolbarTitle(game: Boolean) {
        if (game) {
            toolbar.title = getString(
                R.string.game_question_title,
                viewModel.progress.value,
                viewModel.maxQuestions
            )
        } else {
            toolbar.title = viewModel.title.value
        }
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
        val rulesFragment = RulesFragment.newInstance()
        changeTitle(getString(R.string.rules_title))
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, rulesFragment, rulesFragment.tag)
            .addToBackStack(rulesFragment.tag)
            .commit()
    }

    private fun changeTitle(string: String) {
        viewModel.changeTitle(string)
        viewModel.movingOutOfTitle()
    }

    private fun navigateToAbout() {
        val aboutFragment = AboutFragment.newInstance()
        changeTitle(getString(R.string.about_title))
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, aboutFragment, aboutFragment.tag)
            .addToBackStack(aboutFragment.tag)
            .commit()
    }

    private fun navigateToSettings() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }


    private fun setTitleFragment() {
        val titleFragment = TitleFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcMain, titleFragment, titleFragment.tag)
            .addToBackStack(titleFragment.tag)
            .commit()
    }

}
