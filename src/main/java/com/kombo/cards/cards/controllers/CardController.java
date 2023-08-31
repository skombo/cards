package com.kombo.cards.cards.controllers;

import com.kombo.cards.cards.entities.CardDTO;
import com.kombo.cards.cards.entities.CardRequest;
import com.kombo.cards.cards.entities.CardResponse;
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
    @PostMapping("/cards/create")
    @Operation(summary = "Create Card")
    public ResponseEntity<CardResponse>create(@RequestBody @Valid CardRequest request){
        CardDTO toCreate= new CardDTO();
        toCreate.setColor(request.getColor());
        toCreate.setDescription(request.getDescription());
        toCreate.setName(request.getName());
        CardDTO created=cardService.create(toCreate);
        CardResponse response= new CardResponse();
        response.setColor(created.getColor());
        response.setName(created.getName());
        response.setDescription(created.getDescription());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @Operation(summary = "Get All Cards By Color")
    @GetMapping("cards/colors/{color}/get")
    public ResponseEntity<List<CardResponse>>getAllByColor(@PathVariable String color){
        List<CardDTO>cards=cardService.findByColor(color);
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
