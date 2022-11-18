package com.nabagagem.marketplace;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@AllArgsConstructor
public class MarketplaceController {

    private final GigRepo gigRepo;

    @GetMapping("/marketplace")
    public String list(@ModelAttribute Search search, Model model) {
        model.addAttribute("search",
                Optional.ofNullable(search)
                        .orElse(new Search(""))
        );
        model.addAttribute("gigs", findBy(search));
        return "marketplace";
    }

    private List<Gig> findBy(Search search) {
        return Optional.ofNullable(search)
                .map(Search::searchString)
                .filter(StringUtils::hasText)
                .map(gigRepo::findByTags)
                .orElseGet(() -> StreamSupport.stream(gigRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList()));
    }

}
