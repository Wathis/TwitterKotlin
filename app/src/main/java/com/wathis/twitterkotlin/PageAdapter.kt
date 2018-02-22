package com.wathis.twitterkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val NUMBER_TABS = 4

    override fun getCount(): Int {
        return NUMBER_TABS
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment.newInstance(position)
            1 -> return SearchFragment.newInstance(position)
            2 -> return NotificationFragment.newInstance(position)
            3 -> return MailFragment.newInstance(position)
            else -> return  NotificationFragment.newInstance(position)
        }
    }
/*
    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence {
        when (position) {
            0 -> return "Home"
            1 -> return "Notifications"
            else -> return  "Autre"
        }
    }*/

}

