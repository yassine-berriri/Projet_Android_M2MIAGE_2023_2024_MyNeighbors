package com.example.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.tp3.databinding.ActivityMainBinding
import com.example.tp3.fragments.AddNeighbourFragment
import com.example.tp3.fragments.ListNeighborsFragment

class MainActivity : AppCompatActivity(), NavigationListener  {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar_activity_add)
        setSupportActionBar(this.toolbar)

       // changeFragment(ListNeighborsFragment())
       showFragment(ListNeighborsFragment())
        updateTitle(R.string.titleListVoisin)

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }



    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }

}