package com.kombo.cards.users.services;

import com.kombo.cards.users.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService{

    UserDetailsService userDetailsService();

    User create(User user);
    List<User> getAll(int page, int size);
    User getById(String userId);
}
