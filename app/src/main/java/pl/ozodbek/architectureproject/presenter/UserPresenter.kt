package pl.ozodbek.architectureproject.presenter

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.ozodbek.architectureproject.database.AppDatabase
import pl.ozodbek.architectureproject.database.UserEntity

class UserPresenter(context: Context, private val contractView: ContractView) {

    private val appDatabase = AppDatabase.getInstance(context)
    private val userDao = appDatabase!!.userDao()

    fun setUsers() {
        contractView.showProgressBar()
        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
        contractView.showUsers(userDao.getUsers())
        contractView.hideProgressBar()
        }
    }

    fun addUser(name: String, age: Int) {
        val userEntity = UserEntity(name = name, age = age)
        userDao.addUser(userEntity)
        setUsers()
    }

}