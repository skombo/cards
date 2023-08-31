package com.kombo.cards.cards.repository;

import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> findByNameIgnoreCase(String name);
    List<Card> findByColorIgnoreCase(String color);
    List<Card>findByStatus(CardStatus status);

}
