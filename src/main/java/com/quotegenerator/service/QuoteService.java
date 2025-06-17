package com.quotegenerator.service;

import com.quotegenerator.model.Languages;
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

    public Quote getRandomQuote(Languages language) {
        return quoteRepository.findRandomQuoteByLang(language.name().toLowerCase());
    }

    public List<Quote> getAllQuotesByLanguages(Languages language) {
        return quoteRepository.findAllByLanguage(language.name().toLowerCase());
    }

    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
}