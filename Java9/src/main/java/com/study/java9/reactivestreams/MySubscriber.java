package com.study.java9.reactivestreams;

import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber<String> {
    private final String name;
    private Flow.Subscription subscription;

    public MySubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println(name + " onSubscribe: " + subscription);
        this.subscription = subscription;
        subscription.request(2);  // here, request LONG.MAX_VALUE, it will request everything to the end
    }

    @Override
    public void onNext(String item) {
        System.out.println(name + " received item: " + item);
        if (item.contains(name)) {
            subscription.request(2);    //request two more
        }
        // conditionally use subscription.request(n);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " got an error: " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println(name + " onComplete");
    }
}