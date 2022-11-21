package com.nabagagem.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "marketplace_user")
public class User {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String firstName;

    private String lastName;

    @Embedded
    private Picture picture;

    @Transient
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
    
}
