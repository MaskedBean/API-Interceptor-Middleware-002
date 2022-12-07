package com.example.API.Interceptor.Middleware2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Month {


    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public int getMonthNumber() {
        return monthNumber;
    }
}
