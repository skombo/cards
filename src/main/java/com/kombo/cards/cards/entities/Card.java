package com.kombo.cards.cards.entities;

import com.kombo.cards.users.entities.User;
import com.kombo.cards.utils.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card extends AuditModel {
    @Column(nullable = false)
    private String name;
    @Column(length = 6)
    private String color;
    private  String description;
    private String publicId;
    private CardStatus status=CardStatus.TO_DO;
   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
}
