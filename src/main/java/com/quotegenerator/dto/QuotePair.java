package com.quotegenerator.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuotePair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enText;
    private String enAuthor;
    private String enCategory;

    private String uaText;
    private String uaAuthor;
    private String uaCategory;

    private String language;
}
