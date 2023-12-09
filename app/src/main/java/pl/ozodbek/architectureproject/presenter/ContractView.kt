package pl.ozodbek.architectureproject.presenter

import pl.ozodbek.architectureproject.database.UserEntity

interface ContractView {


    fun showUsers(userList: List<UserEntity>)

    fun showProgressBar()

    fun hideProgressBar()


}