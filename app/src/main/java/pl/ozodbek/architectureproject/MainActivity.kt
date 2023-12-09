package pl.ozodbek.architectureproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import pl.ozodbek.architectureproject.adapter.UserAdapter
import pl.ozodbek.architectureproject.database.UserEntity
import pl.ozodbek.architectureproject.databinding.ActivityMainBinding
import pl.ozodbek.architectureproject.presenter.ContractView
import pl.ozodbek.architectureproject.presenter.UserPresenter


class MainActivity : AppCompatActivity(), ContractView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userPresenter: UserPresenter
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPresenter = UserPresenter(this@MainActivity, this)
        userAdapter = UserAdapter()
        binding.recyclerview.adapter = userAdapter

        userPresenter.setUsers()

        binding.button.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val age = binding.ageEt.text.toString().toInt()

            userPresenter.addUser(name, age)
        }
    }

    override fun showUsers(userList: List<UserEntity>) {
        userAdapter.submitList(userList)
    }

    override fun showProgressBar() {
        binding.progressBar.isVisible = true
        binding.recyclerview.isVisible = false
    }

    override fun hideProgressBar() {
        binding.progressBar.isVisible = false
        binding.recyclerview.isVisible = true

    }
}