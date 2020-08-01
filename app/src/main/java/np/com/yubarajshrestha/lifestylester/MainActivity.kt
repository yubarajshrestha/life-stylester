package np.com.yubarajshrestha.lifestylester

import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_menu.*
import np.com.yubarajshrestha.lifestylester.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var drawer: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpToolbar()

        setUpDrawer()

        setUpNavigation()

        //setUpDrawerEffect()

        loadDefaultView()

        // https://ui8.net/products/v-avenue-ui-kit?rel=nl
        //  https://ik.imagekit.io/ui8/tr:n-full_preview_large/res/robot/image/upload/ljrv78vpzmsl0zcctm6m/1456303604.jpg
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //return super.onCreateOptionsMenu(menu)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun loadDefaultView() {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        supportFragmentManager.beginTransaction().replace(R.id.main_content, HomeFragment()).commit()
    }

    private fun setUpToolbar () {
        toolbar = toolbar_layout
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.elevation = 0f
        }
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.title = ""
    }

    private fun setUpDrawer () {
        drawer = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawerOpen, R.string.drawerClose) {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX: Float = drawerView.width * slideOffset
                app_bar.translationX = slideX
                app_bar.scaleX = 1 - (slideOffset / scaleFactor)
                app_bar.scaleY = 1 - (slideOffset / scaleFactor)
            }
        }
        drawer.syncState()
        drawer_layout.setScrimColor(Color.TRANSPARENT)
        drawer_layout.drawerElevation = 0F
        drawer_layout.addDrawerListener(drawer)

        drawer_menu_layout.setOnClickListener{
            toggleDrawer()
        }


    }

    private fun toggleDrawer() {
        drawer_layout.closeDrawer(GravityCompat.START)
    }

    private fun setUpDrawerEffect() {
        val animationDrawable: AnimationDrawable = drawer_layout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    private fun setUpNavigation() {
        nav_home.setOnClickListener {
            this.toggleDrawer()
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            supportFragmentManager.beginTransaction().setCustomAnimations(R.animator.fade_in, R.animator.fade_out, R.animator.fade_in, R.animator.fade_out).replace(R.id.main_content, HomeFragment()).commit()
        }
    }

    companion object {
        private val scaleFactor = 6F
    }
}
