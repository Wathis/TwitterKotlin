package com.wathis.twitterkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_connection.*


class ConnectionActivity : AppCompatActivity() {

    private var mAuth : FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connection)
        getSupportActionBar()?.hide();
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        loadButtonsTargets()
        mAuth = FirebaseAuth.getInstance()
    }

    fun loadButtonsTargets() {
        button_connection.setOnClickListener {
            val email = edittext_email.text.toString()
            val password = edittext_password.text.toString()
            mAuth?.signInWithEmailAndPassword(email,password)?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = this.mAuth?.currentUser!!
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(applicationContext,"Erreur lors de l'enregistrement",Toast.LENGTH_LONG);
                }
            }
        }
        button_signup.setOnClickListener{
            mAuth?.createUserWithEmailAndPassword(edittext_email.text.toString(),edittext_password.text.toString())?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val firebaseUser = this.mAuth?.currentUser!!
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {
                    Toast.makeText(applicationContext,"Erreur lors de l'enregistrement",Toast.LENGTH_LONG);
                }
            }
        }
    }
}
