package com.example.rxjavapro

class FeakObservable {
    var observerable: IObservable?

    constructor(obserble: IObservable) {
        this.observerable = obserble
    }

    companion object{
        fun create(realObserver: IObservable): FeakObservable {
            return FeakObservable(realObserver)
        }

//        fun map() : FeakObservable{
//            val
//            return FeakObservable(realObserver)
//        }
    }

    fun setObserver(observer: IObserver) {
        observer.onSubscrib()
        this.observerable?.setObserver(observer)
    }


}