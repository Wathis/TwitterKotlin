package com.wathis.twitterkotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by mathisdelaunay on 22/02/2018.
 */

class NotificationFragment : Fragment() {
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page = getArguments().getInt("someInt", 0)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_notifications, container, false)
        return view
    }

    companion object {
        fun newInstance(page: Int): NotificationFragment {
            val fragmentFirst = NotificationFragment()
            val args = Bundle()
            args.putInt("someInt", page)
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }
}