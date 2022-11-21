package com.nabagagem.marketplace.controllers;

import com.nabagagem.marketplace.entity.User;
import com.nabagagem.marketplace.forms.MarketplaceUser;
import com.nabagagem.marketplace.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.security.Principal;

@ControllerAdvice
@AllArgsConstructor
public class LoggedUserController {

    private final ProfileService profileService;

    @ModelAttribute
    public void marketplaceUser(Model model, Principal principal) {
        model.addAttribute("user", loadUser(principal));
    }

    private MarketplaceUser loadUser(Principal principal) {
        if (principal instanceof OAuth2AuthenticationToken token) {
            String id = token.getPrincipal().getAttribute("sub");
            return profileService.findById(id)
                    .map(user -> new MarketplaceUser(
                            id,
                            token.getName(),
                            toPicURL(user)))
                    .orElseGet(this::getAnonymousUser);
        }
        return getAnonymousUser();
    }

    private String toPicURL(User user) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}/picture")
                .buildAndExpand(user.getId())
                .toUri().toString();
    }

    private MarketplaceUser getAnonymousUser() {
        return new MarketplaceUser("id",
                "none",
                "/resources/img.png");
    }

}
