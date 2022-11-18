package com.nabagagem.marketplace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GigController {

    @GetMapping("/gig")
    public String renderGigForm() {
        return "create-gig";
    }

}
