package com.kombo.cards.cards.repository;

import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    Optional<Card> findByNameIgnoreCase(String name);
    Page<Card> findByCreatedAtBetweenAndUser_PublicId(Date startDate, Date endDate,String userId,Pageable pageable);

    Optional<Card>findByPublicId(String publicId);
    Page<Card> findByColorIgnoreCaseAndUser_PublicId(String color,String userId, Pageable pageable);

    Page<Card> findByStatusAndUser_PublicId(CardStatus status,String userId, Pageable pageable);

}
