package com.quotegenerator.service;

import com.quotegenerator.model.Quote;
import com.quotegenerator.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        return quoteRepository.findRandomQuote();
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
}
