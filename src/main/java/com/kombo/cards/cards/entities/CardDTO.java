package com.kombo.cards.cards.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardDTO {
    private String name;
    private String color;
    private String description;
    private Date createdAt;
    private String publicId;

}
