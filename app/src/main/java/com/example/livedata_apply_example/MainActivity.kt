package com.example.livedata_apply_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.livedata_apply_example.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = myViewModel
        }

        button.setOnClickListener {
            myViewModel.setCounter()
        }

        myViewModel.getCounter()?.observe(this, { integer ->
            textView.text = "$integer"
        })
    }
}