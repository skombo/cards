package com.kombo.cards.cards.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CardRequest {
    private String name;
    private String color;
    private  String description;

}
