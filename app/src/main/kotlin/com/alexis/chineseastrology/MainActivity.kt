package com.alexis.chineseastrology

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.alexis.chineseastrology.dagger.general.BaseDaggerActivity
import com.alexis.chineseastrology.general.ViewModelFactory
import com.alexis.chineseastrology.screens.CalculateBirthdayScreen
import com.alexis.chineseastrology.screens.ShowMonthlyFlyingStarsScreen
import com.alexis.chineseastrology.screens.ShowYearlyFlyingStarsScreen
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

internal class MainActivity : BaseDaggerActivity(), IChastroActivity {

    @Inject
    override lateinit var viewModelFactory: ViewModelFactory

    override val fragmentActivity: FragmentActivity
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val drawerToggle = ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close)

        drawerLayout?.addDrawerListener(drawerToggle)
        drawerToggle.syncState();

        setupNavigationView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupNavigationView() {
        nvView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_calcuate_bday -> showCalculateBirthdayScreen()
                R.id.action_show_monthly_flying_stars -> showMonthlyFlyingStarsScreen()
                R.id.action_show_yearly_flying_stars -> showYearlyFlyingStarsScreen()
                R.id.action_determine_current_position -> true
                else -> true //TODO
            }
            true
        }
    }

    private fun showCalculateBirthdayScreen() {
        closeNavigationDrawer()
        viewContainer.removeAllViews()
        viewContainer.addView(CalculateBirthdayScreen(this))
    }

    private fun showYearlyFlyingStarsScreen() {
        closeNavigationDrawer()
        viewContainer.removeAllViews()
        viewContainer.addView(ShowYearlyFlyingStarsScreen(this))
    }

    private fun showMonthlyFlyingStarsScreen() {
        closeNavigationDrawer()
        viewContainer.removeAllViews()
        viewContainer.addView(ShowMonthlyFlyingStarsScreen(this))
    }

    private fun closeNavigationDrawer() {
        drawerLayout.closeDrawers();
    }
}
