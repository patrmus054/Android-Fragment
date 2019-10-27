package com.example.simple

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = SimpleFragmentOne.newInstacne()
        replaceFragment(fragment)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            R.id.firstFragmentItem -> {
                val fragment = SimpleFragmentOne.newInstacne()
                replaceFragment(fragment)
                true
            }
            R.id.secondFragmentItem -> {
                val fragment = SimpleFragmentTwo.newInstacne()
                replaceFragment(fragment)
                true
            }
            R.id.secondActivityItem -> {
                newActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu, menu)
        return true
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

    fun newActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
