package com.wathis.twitterkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.text.Html
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mAdapter: PageAdapter? = null
    private var mPager : ViewPager?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mAuth = FirebaseAuth.getInstance()
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.YELLOW))
        checkUserConnected()
        mAdapter = PageAdapter(supportFragmentManager)

        mPager = view_pager
        mPager?.adapter = mAdapter

        setupTabBar()
        setupActionBar()
    }

    //Setup different icons
    fun setupTabBar() {
        tab_layout?.setupWithViewPager(mPager)
        tab_layout?.getTabAt(0)?.setIcon(R.drawable.home_unselected)
        tab_layout?.getTabAt(1)?.setIcon(R.drawable.search_unselected)
        tab_layout?.getTabAt(2)?.setIcon(R.drawable.alarm_unselected)
        tab_layout?.getTabAt(3)?.setIcon(R.drawable.mail_unselected)

        tab_layout?.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.getIcon()?.setColorFilter(Color.parseColor("#1896eb"), PorterDuff.Mode.SRC_IN);
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.getIcon()?.setColorFilter(Color.parseColor("#8c98a4"), PorterDuff.Mode.SRC_IN);
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    fun setupActionBar() {
    }

    fun checkUserConnected() {
        val currentUser = mAuth?.currentUser
        if (currentUser == null) {
            val connectionIntent = Intent(this, ConnectionActivity::class.java)
            startActivity(connectionIntent)
        }
    }
}
