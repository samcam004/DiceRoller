package com.samcam.project4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import com.samcam.project4.ui.main.RollFragment

class MainActivity : AppCompatActivity(), RollFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}