package com.example.rxjavapro


class ExcutorOnIOObservable(val source : IObservable) : IObservable{

    override fun setObserver(observer: IObserver) {
        Thread{
            source.setObserver(observer)
        }.start()
    }


    class InnerObserver : IObserver{
        override fun onNext(content: String?) {
            TODO("Not yet implemented")
        }

        override fun onSubscrib() {
            TODO("Not yet implemented")
        }

    }


}