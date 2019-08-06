package com.agilezhu.logicalthinking

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.agilezhu.logicalthinking.bean.QuestionDataBean
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val mAdapter = ViewPagerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "产品建议QQ交流群:699041868", Snackbar.LENGTH_LONG)
                .setAction("复制群号", View.OnClickListener {
                    SystemUtil.copy(this, "699041868")
                    Snackbar.make(view, "复制成功", Snackbar.LENGTH_SHORT).show()
                })
                .show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        mHomeDataViewPager.adapter = mAdapter

        val datas = ArrayList<QuestionDataBean>()
        for (index: Int in 0..20) {
            val data = QuestionDataBean()
            data.question = "假设有一个池塘，里面有无穷多的水。现有2个空水壶，容积分别为5升和6升。问题是如何只用这2个水壶从池塘里取得3升的水。"
            data.answer = "1、先把5升的灌满，倒在6升里，这时6升的壶里有5升水 \n" +
                    "2.再把5升的灌满，用5升的壶把6升的灌满，这时5升的壶里剩4升水 \n" +
                    "3.把6升的水倒掉，再把5升壶里剩余的水倒入6升的壶里，这时6升的壶里有4升水 \n" +
                    "4.把5升壶灌满，倒入6升的壶，5-2=3 "
            datas.add(data)
        }
        mAdapter.initData(datas)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
