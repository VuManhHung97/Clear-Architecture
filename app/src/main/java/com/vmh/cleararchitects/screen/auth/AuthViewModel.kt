package com.vmh.cleararchitects.screen.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vmh.cleararchitects.data.models.Post
import com.vmh.cleararchitects.data.models.User
import com.vmh.cleararchitects.data.source.Repository
import com.vmh.cleararchitects.utils.SessionManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val photoRepository: Repository,
    private val sessionManager: SessionManager
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()


    init {
        Log.d(TAG, "AuthViewModel: view model is working...")
    }

    fun authenticate(id: Int) {
        Log.d(TAG, "authenticateWithId: attempting to login.")
        sessionManager.authenticate(queryUser(id))
    }

    private fun queryUser(id: Int): LiveData<AuthResource<out User?>> {
        return LiveDataReactiveStreams.fromPublisher(photoRepository.login(id)
            .onErrorReturn {
                Log.d("AAA", it.localizedMessage)
                val errorUser = User()
                errorUser.id = -1
                errorUser
            }.map {
                if (it.id == -1) {
                    AuthResource.error("Could not authenticate", null)
                } else {
                    AuthResource.authenticated(it)
                }
            }.subscribeOn(Schedulers.io())
        )
    }

    fun observerAuthState(): LiveData<AuthResource<out User?>> {
        return sessionManager.getAuthUser()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    companion object {
        private const val TAG = "AuthViewModel"
    }
}
