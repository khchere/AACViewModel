package com.khchere.newproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.khchere.newproject.R
import com.khchere.newproject.ui.GitSearch.GitRepoFragment
import com.khchere.newproject.ui.GitSearch.dummy.DummyContent
import com.khchere.newproject.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity(), GitRepoFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("MainActivity", "onListFragmentInteraction")
    }

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, GitRepoFragment.newInstance(1))
                    .commitNow()
        }
    }

}
