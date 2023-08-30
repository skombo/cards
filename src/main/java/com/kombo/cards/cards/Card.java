package com.kombo.cards.cards;

import com.kombo.cards.utils.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card extends AuditModel {
    private String name;
    private String color;
    private  String description;
}
