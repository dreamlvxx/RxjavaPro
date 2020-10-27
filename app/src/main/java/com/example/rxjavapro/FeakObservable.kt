package com.example.rxjavapro

class FeakObservable {
    var observerable: IObservable? = null

    constructor(obserble: IObservable) {
        this.observerable = obserble
    }

    companion object{
        fun create(obser: IObservable): FeakObservable {
            return FeakObservable(obser)
        }

    }

    fun map() : FeakObservable{
        return FeakObservable(MapObservable(this.observerable!!))
    }

    fun excuOnIO() : FeakObservable{
        return FeakObservable(ExcutorOnIOObservable(this.observerable!!))
    }

    fun recvOnMain() :FeakObservable{
        return FeakObservable(ReceiveOnMain(this.observerable!!))
    }

    fun setObserver(observer: IObserver) {
        observer.onSubscrib()
        this.observerable?.setObserver(observer)
    }


}