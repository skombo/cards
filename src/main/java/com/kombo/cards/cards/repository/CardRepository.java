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
    Optional<Card>findByPublicId(String publicId);
    List<Card>findByColorIgnoreCaseAndUser_PublicId(String color,String userId);
    List<Card>findByStatusAndUser_PublicId(CardStatus status,String userId);

}
