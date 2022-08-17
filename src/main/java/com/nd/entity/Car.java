package com.nd.entity;

import lombok.Data;

@Data
public class Car {
    private int id;
    private String brand;
    private String model;
    private Client client;
}
