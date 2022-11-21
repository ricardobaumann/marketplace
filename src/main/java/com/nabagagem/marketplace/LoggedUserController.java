package com.nabagagem.marketplace;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class LoggedUserController {

    @ModelAttribute
    public void marketplaceUser(Model model, Principal principal) {
        model.addAttribute("user", loadUser(principal));
    }

    private MarketplaceUser loadUser(Principal principal) {
        if (principal instanceof OAuth2AuthenticationToken token) {
            return new MarketplaceUser(
                    token.getPrincipal().getAttribute("sub"),
                    token.getName(),
                    "/resources/img.png");
        }
        return new MarketplaceUser("id",
                "none",
                "/resources/img.png");
    }

}
