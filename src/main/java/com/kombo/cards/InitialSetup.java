package com.kombo.cards;

import com.kombo.cards.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class InitialSetup {
    private final UserRepository userRepository;

}
