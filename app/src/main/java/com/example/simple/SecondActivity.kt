package com.example.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        replaceFragment(SimpleFragmentOne.newInstacne(), SimpleFragmentTwo.newInstacne())
    }
    private fun replaceFragment(fragmentOne: Fragment, fragmentTwo: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerOne, fragmentOne)
        fragmentTransaction.replace(R.id.fragmentContainerTwo, fragmentTwo)
        fragmentTransaction.commit()
    }
}
