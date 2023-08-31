package com.kombo.cards.users.services;

import com.kombo.cards.users.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final  UserService userService;
    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public List<User> getAll(int page, int size) {
        return null;
    }

    @Override
    public User getById(String userId) {
        return null;
    }
}
