package com.kombo.cards.cards.services;

import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;
import com.kombo.cards.cards.entities.CardUpdate;

import java.util.Date;
import java.util.List;

public interface CardService {
    CardDTO create(String userId,CardDTO card);
    List<CardDTO> findByColor(String userId,String color);
    List<CardDTO> findByStatus(String userId,CardStatus status);
    List<CardDTO>findByDate(String userId,Date date);
    CardDTO update(String userId, CardUpdate update);
    List<CardDTO>findAll(int page, int size);
}
