package com.example.API.Interceptor.Middleware2.interceptors;

import com.example.API.Interceptor.Middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private final Month gennaio = new Month(1, "January", "Gennaio", "Gennaien");
    private final Month febbraio = new Month(2, "February", "Febbraio", "Febbraien");
    private final Month marzo = new Month(3, "March", "Marzo", "Marzen");
    private final Month aprile = new Month(4, "April", "Aprile", "Aprilen");
    private final Month maggio = new Month(5, "May", "Maggio", "Maggen");
    private final Month giugno = new Month(6, "June", "Giugno", "Giugnen");

    private final List<Month> months = new ArrayList<>(Arrays.asList(gennaio, febbraio, marzo, aprile, maggio, giugno));

    public List<Month> getMonths() {
        return months;
    }



    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headerNumber = request.getHeader("monthNumber");
        if (headerNumber == null){
            response.setStatus(400);
            return false;
        }else {
            for (Month month : months) {
                if (month.getMonthNumber() == Integer.parseInt(headerNumber)){
                    return true;
                }
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
