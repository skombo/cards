package com.kombo.cards.cards.controllers;

import com.kombo.cards.cards.entities.*;
import com.kombo.cards.cards.services.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Tag(name = "Card Manager")
@AllArgsConstructor
public class CardController {
    private  final CardService cardService;
    @PostMapping("users/ids/{userId}/cards/create")
    @Operation(summary = "Create Card")
    public ResponseEntity<CardResponse>create(@PathVariable String userId,@RequestBody @Valid CardRequest request){
        CardDTO toCreate= new CardDTO();
        toCreate.setColor(request.getColor());
        toCreate.setDescription(request.getDescription());
        toCreate.setName(request.getName());
        CardDTO created=cardService.create(userId,toCreate);
        CardResponse response= new CardResponse();
        response.setColor(created.getColor());
        response.setName(created.getName());
        response.setDescription(created.getDescription());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Operation(summary = "Get All Cards By Color")
    @GetMapping("users/ids/{userId}/cards/colors/{color}/get")
    public ResponseEntity<List<CardResponse>>getAllByColor(@PathVariable String userId,@PathVariable String color){
        List<CardDTO>cards=cardService.findByColor(userId,color);
        return getListResponseEntity(cards);
    }
    @Operation(summary = "Get All Cards By Color")
    @GetMapping("users/ids/{userId}/cards/status/{status}/get")
public ResponseEntity<List<CardResponse>>getAllByStatus(@PathVariable String userId,@PathVariable CardStatus status){
        List<CardDTO>cards=cardService.findByStatus(userId,status);
        return getListResponseEntity(cards);
    }
    @Operation(summary = "Get All Cards")
    @GetMapping("cards/get/all")
public ResponseEntity<List<CardResponse>>getAll(int page, int size){
        List<CardDTO>cardDTOList= cardService.findAll(page, size);
        return getListResponseEntity(cardDTOList);
}

@PutMapping("/users/ids/{userId}/cards/{cardId}/update")
@Operation(summary = "Update Card")
public ResponseEntity<CardResponse>Update(@PathVariable String userId, @PathVariable String cardId, @RequestBody CardUpdate updateRequest){

}
    private ResponseEntity<List<CardResponse>> getListResponseEntity(List<CardDTO> cards) {
        if(cards.isEmpty())return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        List<CardResponse>responses= new ArrayList<>();
        for(CardDTO cardDTO: cards){
            CardResponse response= new CardResponse();
            response.setDescription(cardDTO.getDescription());
            response.setColor(cardDTO.getColor());
            response.setName(cardDTO.getName());
            responses.add(response);
            response.setPublicId(response.getPublicId());
        }
        return  new ResponseEntity<>(responses,HttpStatus.OK);
    }


}
