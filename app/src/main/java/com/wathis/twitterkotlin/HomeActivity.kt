package com.wathis.twitterkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import java.util.*
import java.util.Arrays.asList
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import android.content.Intent
import kotlinx.android.synthetic.main.activity_home.*
import java.io.Serializable


class HomeActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mAuth = FirebaseAuth.getInstance()
        checkUserConnected()
        val pageAdapter = PageAdapter(supportFragmentManager)

        // create fragments from 0 to 9
        for (i in 0 until 4) {
            pageAdapter.add(PageFragment.newInstance(i), "Tab$i")
        }
        view_pager.adapter = pageAdapter
        tabs.setupWithViewPager(view_pager)
    }

    fun checkUserConnected() {
        val currentUser = mAuth?.currentUser
        if (currentUser == null) {
            val connectionIntent = Intent(this, ConnectionActivity::class.java)
            startActivity(connectionIntent)
        } else {

        }
    }
}
