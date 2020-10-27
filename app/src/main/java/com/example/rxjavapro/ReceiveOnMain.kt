package com.example.rxjavapro

import android.os.Handler
import android.os.Looper
import android.os.Message


class ReceiveOnMain(val source : IObservable) : IObservable {
    override fun setObserver(observer: IObserver) {
        source.setObserver(InnerObserver(observer,handler))
    }

    private var handler= Handler(Looper.getMainLooper()){ message->
        val objj = message.obj
        (objj as IObserver).onNext("excu in main thread")
        return@Handler true
    }

    class InnerObserver(val observer: IObserver,val handler : Handler) : IObserver{
        override fun onNext(content: String?) {
            handler.sendMessage(Message.obtain().apply {
                obj = observer
            })
        }

        override fun onSubscrib() {

        }

    }
}