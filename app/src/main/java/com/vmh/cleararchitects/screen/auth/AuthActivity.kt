package com.vmh.cleararchitects.screen.auth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.vmh.cleararchitects.R
import com.vmh.cleararchitects.screen.main.MainActivity
import com.vmh.cleararchitects.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initView()
        registerLiveData()
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.buttonLogin -> {
                attemptLogin()
            }
        }
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this, providerFactory).get(AuthViewModel::class.java)
        buttonLogin.setOnClickListener(this)
    }

    private fun registerLiveData() {
        viewModel.observerAuthState().observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {
                    }

                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        onLoginSuccess()
                        Log.d(TAG, "registerLiveData: LOGIN SUCCESS " + it.data!!.id)
                    }

                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        Log.e(TAG, "registerLiveData: LOGOUT")
                    }

                    AuthResource.AuthStatus.ERROR -> {
                        Log.e(TAG, "registerLiveData: LOGIN ERROR " + it.message)
                    }
                }
            }
        })
    }

    private fun onLoginSuccess() {
        Log.d(TAG, "onLoginSuccess: login successful!")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun attemptLogin() {
        if (TextUtils.isEmpty(editTextUsername.text.toString())) {
            return
        }
        viewModel.authenticate(editTextUsername.text.toString().toInt())
    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}
