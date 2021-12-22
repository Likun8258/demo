package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @GetMapping(value = "/test")
    public String test(){
        System.out.println("hahahhahha");
        System.out.println("dev分支测试");
        return "哈哈哈哈😄";
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal(2 / 4).multiply(new BigDecimal("100")).setScale(1, BigDecimal.ROUND_HALF_UP));

        BigDecimal multiply = new BigDecimal(2 / 4).multiply(new BigDecimal("100"));
        System.out.println(multiply);

        BigDecimal bigDecimal = new BigDecimal(2).divide(new BigDecimal(4));
        System.out.println(bigDecimal);

        System.out.println(LocalDate.now().plusDays(5).getDayOfWeek().getValue());
        
        LocalDateTime now = LocalDateTime.now().plusDays(-7);
        LocalDateTime monday = now.toLocalDate().with(DayOfWeek.MONDAY).atTime(0,0,0);
        LocalDateTime sunday = now.toLocalDate().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).atTime(LocalTime.MAX);

        System.out.println(monday);
        System.out.println(sunday);

        System.out.println("=================");
        LocalDateTime nowMonday = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).with(DayOfWeek.MONDAY);
        System.out.println(nowMonday);

        Duration duration = Duration.between(LocalDateTime.of(2021,12,12,22,10,0), LocalDateTime.now());
        System.out.println(duration.toDays());

    }

}
