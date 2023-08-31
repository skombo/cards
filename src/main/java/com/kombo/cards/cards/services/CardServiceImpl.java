package com.kombo.cards.cards.services;

import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;
import com.kombo.cards.cards.repository.CardRepository;
import com.kombo.cards.exception.CardServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    @Override
    public CardDTO create(CardDTO card) {
        Optional<Card> toPersist=repository.findByNameIgnoreCase(card.getName());
        if(toPersist.isPresent()) throw new CardServiceException(ErrorMessages.CARD_ALREADY_EXISTS.getErrorMessage());
        return null;
    }

    @Override
    public List<CardDTO> findByColor(String color) {
        return null;
    }

    @Override
    public List<CardDTO> findByStatus(CardStatus status) {
        return null;
    }

    @Override
    public List<CardDTO> findByDate(Date date) {
        return null;
    }

    @Override
    public List<CardDTO> findAll(int page, int size) {
        return null;
    }
}
