package com.calculadora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microsoft.playwright.*;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://testsheepnz.github.io/BasicCalculator.html");
            page.fill("#number1Field", "2");
            page.fill("#number2Field", "3");
            page.selectOption("#selectOperationDropdown", "0");
            page.click("#calculateButton");
            String content = page.locator("#numberAnswerField").inputValue();
            assertEquals("5", content);
        }
    }
}
