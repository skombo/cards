package com.kombo.cards.cards.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CardDTO {
    private String name;
    private String color;
    private String description;
    private Date createdAt;
    private String publicId;

}
