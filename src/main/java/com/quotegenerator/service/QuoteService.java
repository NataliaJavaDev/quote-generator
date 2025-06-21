package com.quotegenerator.service;

import com.quotegenerator.model.Languages;
import com.quotegenerator.model.Quote;
import com.quotegenerator.repository.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote(Languages language) {
        log.info("QuoteService get random quote");
        return quoteRepository.findRandomQuoteByLang(language.name());
    }

    public List<Quote> getAllQuotesByLanguages(Languages language) {
        log.info("QuoteService get all quotes by languages");
        return quoteRepository.findAllByLanguage(language.name());
    }

    public void createQuote(Quote quote) {
        log.info("QuoteService create quote");
        quoteRepository.save(quote);
    }

    public Page<Quote> getAllQuotesByLanguagePaginated(String language, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        log.info("QuoteService get all quotes by languages for add paginated");
        return quoteRepository.findByLanguage(language, pageable);
    }
}