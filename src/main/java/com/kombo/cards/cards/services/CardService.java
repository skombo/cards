package com.kombo.cards.cards.services;

import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;
import com.kombo.cards.cards.entities.CardUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CardService {
    CardDTO create(String userId,CardDTO card);
    Page<CardDTO>findByStatus(String userId,CardStatus status,Pageable pageable);
    Page<CardDTO>findByDate(String userId,Date start,Date end,Pageable pageable);
    CardDTO update(String userId,String cardId, CardUpdate update);
    CardDTO getByPublicId(String publicId);
    Page<CardDTO> findByColor(String userId, String color, Pageable pageable);

    Page<CardDTO>findAll(Pageable pageable);
    void delete(String userId, String cardId);
}
