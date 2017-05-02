package com

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe

/**
 * Created by prashant on 28/4/17.
 */
class MultipleListeners {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new MultipleListeners());
        System.out.println("***********Post 'Multiple Listeners Example'**************");
        System.out.println();
        System.out.println();
        eventBus.post("Multiple Listeners Example");
        eventBus.post(1);
    }

    @Subscribe
    public void task1(String s) {
        System.out.println("do task1(" + s +")");
    }

    @Subscribe
    public void task2(String s) {
        System.out.println("do task2(" + s +")");
    }

    @Subscribe
    public void intTask(Integer i) {
        System.out.println("do intTask(" + i +")");
    }

}
