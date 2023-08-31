package com.kombo.cards.cards.services;

import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;

import java.util.Date;
import java.util.List;

public interface CardService {
    CardDTO create(CardDTO card);
    List<CardDTO> findByColor(String color);
    List<CardDTO> findByStatus(CardStatus status);
    List<CardDTO>findByDate(Date date);
}
