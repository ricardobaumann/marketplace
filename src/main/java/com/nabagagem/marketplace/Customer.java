package com.nabagagem.marketplace;

import lombok.Value;

@Value
public class Customer {
    String id;
    String name;
    String address;
    String serviceRendered;
}
