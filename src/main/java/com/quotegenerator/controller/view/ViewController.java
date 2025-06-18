package com.quotegenerator.controller.view;

import com.quotegenerator.model.Languages;
import com.quotegenerator.model.Quote;
import com.quotegenerator.service.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/view")
public class ViewController {
    private final QuoteService quoteService;

    public ViewController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String selectLanguagePage() {
            return "select-language";
    }

    @GetMapping("/{language}/quotes")
    public String welcomePage(@PathVariable Languages language, Model model) {
        model.addAttribute("language", language);
        return "index";
    }

    @GetMapping("/{language}/quotes/random")
    public String index(@PathVariable Languages language, Model model) {
        Quote quote = quoteService.getRandomQuote(language);
        model.addAttribute("quote", quote);
        model.addAttribute("language", language);
        return "index";
    }

    @GetMapping("/{language}/quotes/all_quotes")
    public String showAllQuotes(@PathVariable Languages language, Model model) {
        List<Quote> quotes = quoteService.getAllQuotesByLanguages(language);
        model.addAttribute("quotes", quotes);
        model.addAttribute("language", language);
        return "show-quotes";
    }

    @GetMapping("/{language}/quotes/create")
    public String showCreateQuoteForm(@PathVariable Languages language, Model model) {
        model.addAttribute("quote", new Quote());
        model.addAttribute("language", language);
        return "create-quote";
    }

    @PostMapping("/{language}/quotes/create")
    public String createNewQuote(@PathVariable Languages language, @ModelAttribute Quote quote, Model model) {

        quoteService.createQuote(quote);
        model.addAttribute("quote", quote);
        //model.addAttribute("language", language);

        return "index";
    }
}