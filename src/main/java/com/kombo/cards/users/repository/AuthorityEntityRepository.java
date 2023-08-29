package com.buyrent.users.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityEntityRepository extends JpaRepository<AuthorityEntity,Long> {
    Optional<AuthorityEntity>findByName(String  name);
}
