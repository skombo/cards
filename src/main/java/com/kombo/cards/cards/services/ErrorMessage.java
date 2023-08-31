package com.kombo.cards.cards.services;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorMessage {
    private Date timestamp;
    private String message;
}
