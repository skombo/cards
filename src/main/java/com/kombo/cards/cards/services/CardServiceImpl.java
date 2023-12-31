package com.kombo.cards.cards.services;
import com.kombo.cards.cards.entities.Card;
import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardStatus;
import com.kombo.cards.cards.entities.CardUpdate;
import com.kombo.cards.cards.repository.CardRepository;
import com.kombo.cards.exception.CardServiceException;
import com.kombo.cards.users.entities.User;
import com.kombo.cards.users.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    private final UserService userService;
    @Override
    public CardDTO create(String userId,CardDTO card) {

        Optional<Card> toPersist=repository.findByNameIgnoreCase(card.getName());
        if(toPersist.isPresent()) throw new CardServiceException(ErrorMessages.CARD_ALREADY_EXISTS.getErrorMessage());
        User user= userService.getById(userId);

        Card toSave=new Card();
        toSave.setName(card.getName());
        toSave.setDescription(card.getDescription());
        toSave.setColor(card.getColor());
        toSave.setPublicId(UUID.randomUUID().toString());
        toSave.setStatus(CardStatus.TO_DO);
        toSave.setUser(user);
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
    public CardDTO getByPublicId(String publicId) {
        Optional<Card>card=repository.findByPublicId(publicId);
        if(card.isPresent()) throw new CardServiceException(ErrorMessages.CARD_NOT_FOUND.getErrorMessage());
        Card persisted=card.get();
        CardDTO response= new CardDTO();
        response.setCreatedAt(persisted.getCreatedAt());
        response.setPublicId(persisted.getPublicId());
        response.setName(persisted.getName());
        response.setDescription(persisted.getDescription());
        return response;
    }

    @Override
    public Page<CardDTO> findByColor(String userId, String color, Pageable pageable) {
        Page<Card>cards= repository.findByColorIgnoreCaseAndUser_PublicId(color,userId,pageable);
        List<CardDTO>cardDTOList= new ArrayList<>();
        for(Card card:cards.getContent()){
            CardDTO cardDTO= new CardDTO();
            cardDTO.setName(card.getName());
            cardDTO.setColor(card.getName());
            cardDTO.setDescription(card.getDescription());
            cardDTO.setPublicId(cardDTO.getPublicId());
               cardDTOList.add(cardDTO);
        };
        Page<CardDTO>responses= new PageImpl<>(cardDTOList);
        return responses;
    }

    @Override
    public Page<CardDTO> findByStatus(String userId,CardStatus status,Pageable pageable) {
        Page<Card>cards=repository.findByStatusAndUser_PublicId(status,userId,pageable);
        List<CardDTO>cardDTOList= new ArrayList<>();
        for(Card card:cards){
            CardDTO cardDTO= new CardDTO();
            cardDTO.setPublicId(card.getPublicId());
            cardDTO.setName(card.getName());
            cardDTO.setColor(card.getColor());
            cardDTO.setDescription(card.getDescription());
            cardDTOList.add(cardDTO);
        }
        Page<CardDTO>response= new PageImpl<>(cardDTOList);
        return response;
    }

    @Override
    public Page<CardDTO> findByDate(String userId,Date start,Date end,Pageable pageable) {
        Page<Card>cards=repository.findByCreatedAtBetweenAndUser_PublicId(start,end,userId,pageable);
        List<CardDTO>cardDTOList= new ArrayList<>();
        for(Card card:cards){
            CardDTO cardDTO= new CardDTO();
            cardDTO.setPublicId(card.getPublicId());
            cardDTO.setName(card.getName());
            cardDTO.setColor(card.getColor());
            cardDTO.setDescription(card.getDescription());
            cardDTOList.add(cardDTO);

        }
        Page<CardDTO>response= new PageImpl<>(cardDTOList);
        return response;
    }

    @Override
    public Page<CardDTO> findAll(Pageable pageable) {
        Page<Card> cardPage=repository.findAll(pageable);
        List<Card>cards=cardPage.getContent();
        List<CardDTO>cardDTOList= new ArrayList<>();
        for(Card card: cards){
            CardDTO cardDTO= new CardDTO();
            cardDTO.setCreatedAt(card.getCreatedAt());
            cardDTO.setName(card.getName());
            cardDTO.setPublicId(card.getPublicId());
            cardDTO.setColor(card.getColor());
            cardDTOList.add(cardDTO);
        }
        Page<CardDTO>response= new PageImpl<>(cardDTOList);

        return response;
    }




    @Override
    public CardDTO update(String userId,String cardId, CardUpdate update) {
        Optional<Card>card=repository.findByPublicId(cardId);
        if(card.isEmpty())throw new CardServiceException(ErrorMessages.CARD_NOT_FOUND.getErrorMessage());
        Card toUpdate=card.get();
        toUpdate.setName(update.getName());
        toUpdate.setColor(update.getColor());
        toUpdate.setStatus(update.getStatus());
        toUpdate.setDescription(update.getDescription());
        Card saved=repository.save(toUpdate);

        CardDTO response= new CardDTO();
        response.setColor(saved.getColor());
        response.setName(saved.getName());
        response.setDescription(saved.getDescription());
        response.setPublicId(saved.getPublicId());
        response.setCreatedAt(saved.getCreatedAt());
        return response;
    }

    @Override
    public void delete(String userId, String cardId) {
        Optional<Card>card=repository.findByPublicId(cardId);
        if(card.isEmpty()) throw new CardServiceException(ErrorMessages.CARD_NOT_FOUND.getErrorMessage());
        repository.delete(card.get());
    }
}
