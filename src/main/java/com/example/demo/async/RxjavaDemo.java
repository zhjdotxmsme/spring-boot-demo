package com.example.demo.async;


import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月21日 11:59
 * @modified By
 */
public class RxjavaDemo {

    public static void main(String[] args) throws InterruptedException {
        /**
         * RxJava的模型描述：
         * Observer，观察者，它决定事件触发的时候有怎样的行为
         * Subscriber,Observer的一个抽象类，对Observer进行了扩展，增加了onStart()和unsubscribe()两个方法
         *              onStart()会在 subscribe 刚开始，而事件还未发送之前被调用,用于做一些准备工作，例如数据的清零或重置
         *              和unSubscribe()一般在这个方法调用前，可以使用 isUnsubscribed() 先判断一下状态
         * Observable,被观察者，它决定什么时候触发事件以及触发怎样的事件
         * Subscribe，订阅
         *
         */
        Observable.create((ObservableOnSubscribe<Integer>) e -> {
            e.onNext(1);
            e.onNext(2);
            e.onNext(3);
            e.onComplete();
            e.onNext(1);
        }).subscribe(new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                i++;
                if (2 == i) {
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

        Flowable.just("hello world").subscribe(System.out::println);
        Flowable.range(0, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation()))
                .map(w -> w * w)
                .blockingSubscribe(System.out::println);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000);
    }

}
