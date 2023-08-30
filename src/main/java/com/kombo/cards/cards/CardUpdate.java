package com.kombo.cards.cards;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardUpdate {
    private String name;
    private String color;
    private String description;
    private CardStatus status;

}
