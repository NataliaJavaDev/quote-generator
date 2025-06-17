package com.quotegenerator.controller;

import com.quotegenerator.model.Languages;
import com.quotegenerator.model.Quote;
import com.quotegenerator.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
}