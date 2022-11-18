package com.nabagagem.marketplace;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Controller
public class MarketplaceController {

    @GetMapping("/marketplace")
    public String list(@ModelAttribute Search search, Model model) {
        model.addAttribute("search",
                Optional.ofNullable(search)
                        .orElse(new Search(""))
        );
        model.addAttribute("gigs",
                List.of(
                        new Gig("a primeira", "e a mais legal"),
                        new Gig("a segunda", "e a mais boa"),
                        new Gig("a terceira", "nheee"),
                        new Gig("a quarta", "nheee"),
                        new Gig("a quinta", "nheee")
                )
        );
        return "marketplace";
    }

}
