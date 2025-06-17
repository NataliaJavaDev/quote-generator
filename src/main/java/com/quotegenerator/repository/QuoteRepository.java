package com.quotegenerator.repository;

import com.quotegenerator.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    @Query("SELECT q FROM Quote q ORDER BY function('RAND')")
    Quote findRandomQuote(); // H2 підтримує RAND()
}