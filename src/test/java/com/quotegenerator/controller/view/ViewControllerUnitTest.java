package com.quotegenerator.controller.view;

import com.quotegenerator.model.*;
import com.quotegenerator.service.QuoteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;

public class ViewControllerUnitTest {

    private final QuoteService quoteService = Mockito.mock(QuoteService.class);
    private final ViewController controller = new ViewController(quoteService);

    @Test
    void welcomePage_shouldAddLanguageToModelAndReturnIndexView() {
        Model model = new ExtendedModelMap();

        String viewName = controller.welcomePage(Languages.EN, model);

        assertEquals("index", viewName);
        assertEquals(Languages.EN, model.getAttribute("language"));
    }

    @Test
    void showCreateQuoteForm_shouldAddEmptyQuoteAndReturnForm() {
        Model model = new ExtendedModelMap();

        String viewName = controller.showCreateQuoteForm(Languages.UA, model);

        assertEquals("create-quote", viewName);
        assertNotNull(model.getAttribute("quote"));
        assertEquals(Languages.UA, model.getAttribute("language"));
    }

    @Test
    void createQuote_shouldAddQuoteToModelAndReturnIndexView() {
        Quote quote = new Quote(null, "text", "author", "category", "EN");
        Model model = new ExtendedModelMap();

        String viewName = controller.createNewQuote(Languages.EN, quote, model);

        assertEquals("index", viewName);
        assertEquals(quote, model.getAttribute("quote"));
    }
}