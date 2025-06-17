package com.quotegenerator.controller;

import com.quotegenerator.model.Languages;
import com.quotegenerator.model.Quote;
import com.quotegenerator.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{language}/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandomQuote(@PathVariable Languages language) {
        return quoteService.getRandomQuote(language);
    }

    @GetMapping("/all_quotes")
    public List<Quote> getAllQuotes(@PathVariable Languages language) {
        return quoteService.getAllQuotesByLanguages(language);
    }
}