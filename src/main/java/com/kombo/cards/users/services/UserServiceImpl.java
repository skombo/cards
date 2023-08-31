package com.kombo.cards.users.services;

import com.kombo.cards.cards.services.ErrorMessages;
import com.kombo.cards.exception.UserServiceException;
import com.kombo.cards.users.entities.User;
import com.kombo.cards.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public User create(User user) {
        Optional<User> userOptional=repository.findByEmail(user.getEmail());
        if(userOptional.isPresent())throw new UserServiceException(ErrorMessages.USER_ALREADY_EXISTS.getErrorMessage());
        User toSave= new User();
        toSave.setEmail(user.getEmail());
        toSave.setPublicId(UUID.randomUUID().toString());
        return repository.save(toSave);
    }

    @Override
    public List<User> getAll(int page, int size) {
        return null;
    }

    @Override
    public User getById(String userId) {
        Optional<User>user=repository.findByPublicId(userId);
        if(user.isEmpty()) throw new UserServiceException(ErrorMessages.USER_NOT_FOUND.getErrorMessage());
        return user.get();
    }
}
