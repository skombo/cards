package com.kombo.cards.users.entities;

import com.kombo.cards.utils.AuditModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity extends AuditModel {
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role name;

}
