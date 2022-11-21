package com.nabagagem.marketplace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Picture {
    @Column(nullable = false)
    private String mediaType;

    @Column(nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    @Column(nullable = false)
    private String name;
}