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
                Log.i("xxx", "上游线程:${Thread.currentThread().name}")
                observer.onNext("this is message")
            }
        })
                .map()
                .excuOnIO()
                .recvOnMain()
                .setObserver(object : IObserver {
            override fun onNext(content: String?) {
                Log.i("xxx", "下游线程:${Thread.currentThread().name}")
                Log.e("xxx","content is $content")
            }

            override fun onSubscrib() {
                Log.e("xxx","onSubscrib is excu")
            }
        })

    }
}