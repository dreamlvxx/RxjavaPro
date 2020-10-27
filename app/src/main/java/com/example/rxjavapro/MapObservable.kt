package com.example.rxjavapro

class MapObservable(val source: IObservable) : IObservable {

    override fun setObserver(observer: IObserver) {
        source.setObserver(InnerObserver(observer))
    }


    class InnerObserver(val observer : IObserver) : IObserver {

        override fun onNext(content: String?) {
            // TODO: 2020/10/27 midify ---> content
            observer.onNext("this is content after map")
        }

        override fun onSubscrib() {
            observer.onSubscrib()
        }

    }

}