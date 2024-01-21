package com.examenp.recyclerview.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.examenp.recyclerview.R
import com.examenp.recyclerview.data.entities.Users
import com.examenp.recyclerview.databinding.ActivityMainBinding
import com.rivera.dispositivostest.ui.adapters.UsersAdapter

class MainActivity : AppCompatActivity() {

    private var usersList: MutableList<Users> = ArrayList<Users>()

    private lateinit var binding: ActivityMainBinding
    private var usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initListeners()
    }

    private fun initRecyclerView() {
        binding.rvUsers.adapter = usersAdapter
        binding.rvUsers.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    private fun initListeners(){

        binding.btnInsert.setOnClickListener {
            val us = Users(
                1,
                "Willan",
                "El estudiante",
                "https://cdn3.iconfinder.com/data/icons/web-design-and-development-2-6/512/87-1024.png"
            )
            usersList.add(us)
            usersAdapter.listUsers = usersList
            usersAdapter.notifyDataSetChanged()
        }
    }
}