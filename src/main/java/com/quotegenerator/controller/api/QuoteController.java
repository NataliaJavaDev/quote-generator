package com.quotegenerator.controller.api;

import com.quotegenerator.model.*;
import com.quotegenerator.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/{language}/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandomQuote(@PathVariable Languages language) {
        log.info("Getting random quote");
        return quoteService.getRandomQuote(language);
    }

    @GetMapping("/all_quotes")
    public List<Quote> getAllQuotes(@PathVariable Languages language) {
        log.info("Getting all quotes");
        return quoteService.getAllQuotesByLanguages(language);
    }
}