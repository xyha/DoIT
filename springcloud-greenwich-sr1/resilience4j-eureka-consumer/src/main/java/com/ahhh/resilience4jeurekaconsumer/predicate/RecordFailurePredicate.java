package com.ahhh.resilience4jeurekaconsumer.predicate;


import java.util.function.Predicate;

/**
 * @author ahhh
 * @title: RecordFailurePredicate
 * @projectName eureka-server
 * @description: TODO
 * @date 2020/12/16
 */
public class RecordFailurePredicate implements Predicate<Throwable> {
    @Override
    public boolean test(Throwable throwable) {
        System.out.println("predicate>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return true;
    }
}
