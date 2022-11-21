package com.nabagagem.marketplace.entity;

import lombok.Value;

@Value
public class Customer {
    String id;
    String name;
    String address;
    String serviceRendered;
}
