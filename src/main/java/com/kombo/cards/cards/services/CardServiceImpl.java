package com.kombo.cards.cards.services;

import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;
import com.kombo.cards.cards.repository.CardRepository;
import com.kombo.cards.exception.CardServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    @Override
    public CardDTO create(CardDTO card) {
        Optional<Card> toPersist=repository.findByNameIgnoreCase(card.getName());
        if(toPersist.isPresent()) throw new CardServiceException(ErrorMessages.CARD_ALREADY_EXISTS.getErrorMessage());
        Card toSave=new Card();
        toSave.setName(card.getName());
        toSave.setDescription(card.getDescription());
        toSave.setPublicId(UUID.randomUUID().toString());
        toSave.setStatus(CardStatus.TO_DO);
        Card created=repository.save(toSave);

        CardDTO response= new CardDTO();
        response.setCreatedAt(created.getCreatedAt());
        response.setName(created.getName());
        response.setDescription(created.getDescription());
        response.setPublicId(created.getPublicId());
        response.setColor(created.getColor());
        return response;
    }

    @Override
    public List<CardDTO> findByColor(String color) {
        List<Card>cards= repository.findByColor(color);
        List<CardDTO>responses= new ArrayList<>();
        for(Card card:cards){
            CardDTO cardDTO= new CardDTO();
            cardDTO.setName(card.getName());
            cardDTO.setColor(card.getName());
            cardDTO.setDescription(card.getDescription());
            cardDTO.setPublicId(cardDTO.getPublicId());
               responses.add(cardDTO);
        };
        return responses;
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
