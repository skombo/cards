package com.kombo.cards.users.repository;

import com.kombo.cards.users.entities.Role;
import com.kombo.cards.users.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByName(Role name);

}
