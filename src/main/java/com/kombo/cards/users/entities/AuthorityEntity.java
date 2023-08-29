package com.kombo.cards.users.entities;

import com.kombo.cards.utils.AuditModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serial;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "authorities")
@SQLDelete(sql = "UPDATE authorities SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class AuthorityEntity extends AuditModel {
    @Serial
    private static final long serialVersionUID = -3928287819056528715L;

    private String publicId;
    private boolean deleted = Boolean.FALSE;
    @Column(nullable = false,length = 20)
    private String name;
    @ManyToMany(mappedBy = "authorities")
    private Collection<RoleEntity> roles;
}

