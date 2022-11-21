package com.nabagagem.marketplace.controllers;

import com.nabagagem.marketplace.forms.MarketplaceUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "profile/show";
    }

    @GetMapping("/profile/edit")
    public String editProfile() {
        return "edit-profile";
    }

    @PostMapping("/profile")
    public String update(MarketplaceUser marketplaceUser) {

        return "profile/show";
    }
}
