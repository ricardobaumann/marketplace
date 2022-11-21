package com.nabagagem.marketplace.repos;

import com.nabagagem.marketplace.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
}
