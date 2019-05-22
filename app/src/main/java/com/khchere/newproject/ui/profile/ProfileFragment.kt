package com.khchere.newproject.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.main_fragment.*


class ProfileFragment : Fragment() {

    companion object {
        private const val DEFAULT_AUTH_CODE = "96T56LHO"
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: UserProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(com.khchere.newproject.R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userAuthCode = savedInstanceState?.getString("UID_KEY")?: DEFAULT_AUTH_CODE
        Log.d("MyRepository","onActivityCreated")
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        viewModel.init(userAuthCode)

        viewModel.user.observe(this, Observer {
            Log.d("MyRepository","observeData !! :  $it")
            message.text = it.toString()
        })
    }

}
