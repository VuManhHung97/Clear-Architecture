package com.vmh.cleararchitects.screen.main.information

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vmh.cleararchitects.data.models.User
import com.vmh.cleararchitects.data.source.Repository
import com.vmh.cleararchitects.screen.auth.AuthResource
import com.vmh.cleararchitects.utils.SessionManager
import javax.inject.Inject

class InformationViewModel @Inject constructor(
    private val photoRepository: Repository,
    private val sessionManager: SessionManager
): ViewModel() {

    fun getAuthenticatedUser(): LiveData<AuthResource<out User?>> {
        return sessionManager.getAuthUser()
    }

    companion object {
        private const val TAG = "InformationViewModel"
    }
}
