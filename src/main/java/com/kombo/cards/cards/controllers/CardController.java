package com.kombo.cards.cards.controllers;

import com.kombo.cards.cards.services.CardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Tag(name = "Card Manager")
@AllArgsConstructor
public class CardController {
    private  final CardService cartService;
}
