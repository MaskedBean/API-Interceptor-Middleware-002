package com.example.API.Interceptor.Middleware2.controllers;

import com.example.API.Interceptor.Middleware2.entities.Month;
import com.example.API.Interceptor.Middleware2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
@RequestMapping("/months")
public class MonthController {

    @Autowired
    private MonthInterceptor monthInterceptor;

    @GetMapping("/{monthNumber}")
    public Month takeSingleMonth(@PathVariable int monthNumber){
        List<Month> months2 = monthInterceptor.getMonths();
        for (Month month : months2) {
            if (month.getMonthNumber() == monthNumber){
                System.out.println("month found");
                return month;
            }
        }
        return new Month(0, "nope", "nope", "nope");
    }
}
