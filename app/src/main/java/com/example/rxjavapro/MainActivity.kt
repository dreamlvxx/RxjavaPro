package com.example.rxjavapro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FeakObservable.create(object : IObservable {
            override fun setObserver(observer: IObserver) {
                observer.onNext("this is message")
            }
        })
                .map()
                .setObserver(object : IObserver {
            override fun onNext(content: String?) {
                Log.e("xxx","content is $content")
            }

            override fun onSubscrib() {
                Log.e("xxx","onSubscrib is excu")
            }
        })

    }
}