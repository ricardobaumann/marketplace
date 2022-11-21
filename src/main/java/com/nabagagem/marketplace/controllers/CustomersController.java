package com.nabagagem.marketplace.controllers;

import com.nabagagem.marketplace.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CustomersController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        model.addAttribute("customers", List.of(
                new Customer(
                        "1",
                        "first",
                        "first address",
                        "foobar"
                )
        ));
        model.addAttribute("username", principal.getName());

        return "customers";
    }

}
