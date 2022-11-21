package com.nabagagem.marketplace.services;

import com.nabagagem.marketplace.entity.User;
import com.nabagagem.marketplace.repos.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfileService {

    private final UserRepo userRepo;

    public Optional<User> findById(String id) {
        return userRepo.findById(id);
    }
}
