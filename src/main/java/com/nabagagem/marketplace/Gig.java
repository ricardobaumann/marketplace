package com.nabagagem.marketplace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Gig {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(name = "gig_tags",
            indexes = {
                    @Index(columnList = "tag"),
                    @Index(columnList = "tag, gig_id", unique = true)
            },
            joinColumns = @JoinColumn(name = "gig_id"))
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    public String tagsToString() {
        return Optional.ofNullable(tags)
                .map(strings -> String.join(",", tags))
                .orElse("");
    }

}
