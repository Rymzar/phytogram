package com.example.phytogram.fragments

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.phytogram.R
import com.example.phytogram.databinding.ActivityHomeBinding
import com.example.phytogram.fragments.add.AddFragment
import com.example.phytogram.fragments.guide.GuideFragment
import com.example.phytogram.fragments.home.HomeFragment
import com.example.phytogram.fragments.notification.NotificationsFragment
import com.example.phytogram.fragments.search.SearchFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

/* binding.navView.setOnNavigationItemReselectedListener {
     when(it.itemId){
         R.id.navigation_home ->{
             Toast.makeText(this,"navigation_home", Toast.LENGTH_SHORT).show()

         }
         R.id.navigation_search ->{
             Toast.makeText(this,"navigation_search", Toast.LENGTH_SHORT).show()

         }
         R.id.navigation_add->{
             Toast.makeText(this,"navigation_add", Toast.LENGTH_SHORT).show()

         }
         R.id.navigation_notifications ->{
             Toast.makeText(this,"navigation_notifications", Toast.LENGTH_SHORT).show()

         }
         R.id.navigation_search ->{
             Toast.makeText(this,"navigation_search", Toast.LENGTH_SHORT).show()

         }


     }
     true
 }*/

    val navView: BottomNavigationView = binding.navView


    val navController = findNavController(R.id.nav_host_fragment_activity_home)
    // Pasng each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(
     setOf(
         R.id.navigation_home, R.id.navigation_search,
         R.id.navigation_add, R.id.navigation_notifications,
         R.id.navigation_guide
     )
 )
 setupActionBarWithNavController(navController, appBarConfiguration)
 navView.setupWithNavController(navController)
}
}
