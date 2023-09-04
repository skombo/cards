package com.kombo.cards;

import com.kombo.cards.users.entities.Role;
import com.kombo.cards.users.entities.User;
import com.kombo.cards.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Slf4j
public class InitialSetup {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event){
        Optional<User> checkAdmin= userRepository.findByEmail("admin@test.com");
        if(checkAdmin.isPresent()){

        }else{
            User officer = new User();
            officer.setFirstName("System");
            officer.setLastName("Administrator");
            officer.setEmail("admin@test.com");
            officer.setPublicId(UUID.randomUUID().toString());
            officer.setPassword(bCryptPasswordEncoder.encode("admin@test.com"));
            officer.setRole(Role.ADMIN);
            officer.setActive(true);
            log.info("creating administrative user");
            userRepository.save(officer);
            log.info("completed creating administrative user");

        }

        Optional<User> checkMember= userRepository.findByEmail("member@test.com");
        if(checkMember.isPresent()){

        }else{
            User officer = new User();
            officer.setFirstName("Test");
            officer.setLastName("Member");
            officer.setEmail("member@test.com");
            officer.setPublicId(UUID.randomUUID().toString());
            officer.setPassword(bCryptPasswordEncoder.encode("member@test.com"));
            officer.setRole(Role.MEMBER);
            officer.setActive(true);
            log.info("creating member");
            userRepository.save(officer);
            log.info("completed creating member");

        }

    }

}
