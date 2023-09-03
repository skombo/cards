package com.kombo.cards.cards.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String name;
    private String color;
    private  String description;
    private  String publicId;
    private Date createdAt;
}
