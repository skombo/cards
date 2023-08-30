package com.kombo.cards.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> findByNameIgnoreCase(String name);
    List<Card> findByColor(String color);
}
