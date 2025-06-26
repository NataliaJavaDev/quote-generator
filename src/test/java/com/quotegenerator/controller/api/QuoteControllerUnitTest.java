package com.quotegenerator.controller.api;

import com.quotegenerator.model.*;
import com.quotegenerator.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuoteControllerUnitTest {

    private final QuoteService quoteService = Mockito.mock(QuoteService.class);
    private final QuoteController controller = new QuoteController(quoteService);

    @Test
    void getRandomQuote_shouldReturnQuote() {
        Quote expected = new Quote(1L, "Text", "Author", "Category", "EN");
        Mockito.when(quoteService.getRandomQuote(Languages.EN)).thenReturn(expected);

        Quote result = controller.getRandomQuote(Languages.EN);

        assertEquals(expected, result);
    }

    @Test
    void getAllQuotes_shouldReturnList() {
        List<Quote> expected = List.of(
                new Quote(1L, "Text", "Author", "Category", "EN")
        );
        Mockito.when(quoteService.getAllQuotesByLanguages(Languages.EN)).thenReturn(expected);

        List<Quote> result = controller.getAllQuotes(Languages.EN);

        assertEquals(expected, result);
    }
}