package com.example.demo.test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class TestMain1 {
    public static void main(String[] args) {
        //本周的时间范围
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime monday = now.toLocalDate().with(DayOfWeek.MONDAY).atTime(0, 0, 0);
        LocalDateTime sunday = now.toLocalDate().with(DayOfWeek.SUNDAY).atTime(23, 59, 59);

        System.out.println(monday);
        System.out.println(sunday);
    }

}
