package com.quotegenerator.repository;

import com.quotegenerator.model.Quote;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findAllByLanguage(String lang);

    @Query(value = "SELECT * FROM quote WHERE language = ?1 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote findRandomQuoteByLang(String lang);

    Page<Quote> findByLanguage(String language, Pageable pageable);
}