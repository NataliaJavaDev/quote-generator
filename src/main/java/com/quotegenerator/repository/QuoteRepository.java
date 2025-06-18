package com.quotegenerator.repository;

import com.quotegenerator.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(value = "SELECT * FROM quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote findRandomQuote();

    List<Quote> findAllByLanguage(String lang);

    @Query(value = "SELECT * FROM quote WHERE language = ?1 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote findRandomQuoteByLang(String lang);
}
