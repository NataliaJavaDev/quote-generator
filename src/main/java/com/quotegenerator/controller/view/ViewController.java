package com.quotegenerator.controller.view;

import com.quotegenerator.model.*;
import com.quotegenerator.service.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Slf4j
@Controller
@RequestMapping("/view")
public class ViewController {
    private final QuoteService quoteService;

    public ViewController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/")
    public String selectLanguagePage() {
        log.info("Show select language page");
        return "select-language";
    }

    @GetMapping("/{language}/quotes")
    public String welcomePage(@PathVariable Languages language, Model model) {
        model.addAttribute("language", language);

        if (language == null) {
            log.atError().log("Language is null in welcomePage!");
        } else {
            log.info("Getting quotes for language {}", language);
        }
        return "index";
    }

    @GetMapping("/{language}/quotes/random")
    public String index(@PathVariable Languages language, Model model) {

        log.info("GET /{}/quotes/random - Getting random quote", language);

        Quote quote = quoteService.getRandomQuote(language);
        model.addAttribute("quote", quote);
        model.addAttribute("language", language);

        if (quote == null) {
            log.error("Quote is null for language: {}", language);
        } else {
            log.info("Random quote retrieved: {}", quote.getId());
        }

        return "index";
    }

    @GetMapping("/{language}/quotes/all_quotes")
    public String showAllQuotesPaginated(
            @PathVariable Languages language,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        log.info("GET /{}/quotes/all_quotes - Page: {}", language, page);

        int pageSize = 2;

        Page<Quote> quotesPage = quoteService.getAllQuotesByLanguagePaginated(language.name(), page, pageSize);

        log.info("Quotes page retrieved - Total pages: {}, Quotes on page: {}",
                quotesPage.getTotalPages(), quotesPage.getContent().size());

        model.addAttribute("quotes", quotesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", quotesPage.getTotalPages());
        model.addAttribute("language", language);

        return "show-quotes";
    }

    @GetMapping("/{language}/quotes/create")
    public String showCreateQuoteForm(@PathVariable Languages language, Model model) {

        log.info("GET /{}/quotes/create - Showing quote creation form", language);

        model.addAttribute("quote", new Quote());
        model.addAttribute("language", language);
        return "create-quote";
    }

    @PostMapping("/{language}/quotes/create")
    public String createNewQuote(@PathVariable Languages language, @ModelAttribute Quote quote, Model model) {
        log.info("POST /{}/quotes/create - Creating new quote: {}", language, quote);

        quoteService.createQuote(quote);
        log.info("Quote created with ID: {}", quote.getId());

        model.addAttribute("quote", quote);
        return "index";
    }
}