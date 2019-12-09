package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //declare an instant of viewmodal
    private lateinit var viewModal: CounterViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialise viewmodal
        viewModal = ViewModelProviders.of(this).get(CounterViewModal::class.java)

        //Add observer
        viewModal.counter.observe(this, Observer<Int>{
            if(viewModal.counter.value == 10) endGame()
        })

        buttonIncrement.setOnClickListener{
            viewModal.increment()
            textViewCounter.text = viewModal.counter.value.toString()
        }

        buttonDecrement.setOnClickListener {
            viewModal.decreament()
            textViewCounter.text = viewModal.counter.value.toString()
        }
    }

    private fun endGame() {
        Toast.makeText(applicationContext, "Counter == 10", Toast.LENGTH_LONG).show()
    }
}
