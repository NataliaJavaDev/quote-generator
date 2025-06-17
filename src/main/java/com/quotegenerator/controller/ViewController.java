package com.quotegenerator.controller;

import com.quotegenerator.dto.QuotePair;
import com.quotegenerator.model.Languages;
import com.quotegenerator.model.Quote;
import com.quotegenerator.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class ViewController {
    private final QuoteService quoteService;

    public ViewController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String selectLanguagePage() {
            return "select-language";
    }

    @GetMapping("/{language}")
    public String index(@PathVariable Languages language, Model model) {
        Quote quote = quoteService.getRandomQuote(language);
        model.addAttribute(
                "quote",
                quote
        );
        model.addAttribute(
                "language",
                language
        );
        return "index";
    }

    @GetMapping("/{language}/all_quotes")
    public String showAllQuotes(@PathVariable Languages language, Model model) {
        List<Quote> quotes = quoteService.getAllQuotesByLanguages(language);
        model.addAttribute("quotes", quotes);
        model.addAttribute("language", language);
        return "show-quotes";
    }

    @GetMapping("/create")
    public String showCreateQuoteForm(Model model) {
        model.addAttribute("quotePair", new QuotePair());
        model.addAttribute("language", Languages.values());
        model.addAttribute("text", "Create a new quote");
        model.addAttribute("author", "Who are author");
        model.addAttribute("category", "What is category");
        return "create-quote";
    }

    @PostMapping("/create")
    public String createNewQuote(@ModelAttribute QuotePair quotePair) {

        Quote enQuote = new Quote();

        enQuote.setText(quotePair.getEnText());
        enQuote.setAuthor(quotePair.getEnAuthor());
        enQuote.setCategory(quotePair.getEnCategory());

        enQuote.setLanguage("EN");

        Quote uaQuote = new Quote();

        uaQuote.setText(quotePair.getUaText());
        uaQuote.setAuthor(quotePair.getUaAuthor());
        uaQuote.setCategory(quotePair.getUaCategory());

        uaQuote.setLanguage("UA");

        quoteService.createQuote(enQuote);
        quoteService.createQuote(uaQuote);

        return "select-language";
    }
}