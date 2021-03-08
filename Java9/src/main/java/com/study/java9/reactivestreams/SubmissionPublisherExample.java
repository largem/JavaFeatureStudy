package com.study.java9.reactivestreams;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class SubmissionPublisherExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        SubmissionPublisher<String> sb = new SubmissionPublisher<>(executor, Flow.defaultBufferSize());

        //Just be noted: which subscriber receive subscription is not determined. Try to run the program multiple times.
        sb.subscribe(new MySubscriber("Sub1"));
        sb.subscribe(new MySubscriber("Sub2"));
        sb.submit("item 1");
        sb.submit("item 2, Sub2");
        sb.submit("item 3");
        sb.submit("item 4");
        sb.submit("item 5");

        executor.shutdown();
    }
}
