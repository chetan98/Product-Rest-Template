package com.demo.countries.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestModel {

    private int id;
    private String name;
    private int qty;
    private double price;
}
