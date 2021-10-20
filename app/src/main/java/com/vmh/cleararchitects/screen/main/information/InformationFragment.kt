package com.vmh.cleararchitects.screen.main.information

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.vmh.cleararchitects.R
import com.vmh.cleararchitects.data.models.User
import com.vmh.cleararchitects.screen.auth.AuthResource
import com.vmh.cleararchitects.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_information.*
import javax.inject.Inject

class InformationFragment : DaggerFragment(R.layout.fragment_information) {
    private lateinit var viewModel: InformationViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        subscribeObservers()
    }

    private fun initView() {
        viewModel =
            ViewModelProviders.of(this, providerFactory).get(InformationViewModel::class.java)
    }

    private fun subscribeObservers() {
        viewModel.getAuthenticatedUser().observe(viewLifecycleOwner, {
            if (it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        setInformationDetail(it.data!!)
                    }

                    AuthResource.AuthStatus.ERROR -> {
                        setErrorDetail(it.message!!)
                    }
                }
            }
        })
    }

    private fun setErrorDetail(message: String) {
        email.text = message
        username.text = "Error"
        website.text = "Error"
    }

    private fun setInformationDetail(user: User) {
        email.text = user.email
        username.text = user.username
        website.text = user.website
    }

    companion object {
        private const val TAG = "InformationFragment"
    }
}
