package com.Envelo.Zad3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class StartupRunner implements CommandLineRunner {
    @Autowired
    QuoteService quoteService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome in Kanye West Qutes Application!");
        System.out.println("Type 'next' to see quote by Kanye or 'exit' to close application.");
        List<String> quotes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int quotesListSize = quoteService.qetQuotesListSize();
        String command = scanner.nextLine();
        while (true) {
            Quote quote = quoteService.getKayneQuote();
            String quoteText = quote.getQuote();
            if (command.equals("exit")) {
                System.exit(0);
            }
            if (quotes.size() == quotesListSize) {
                System.out.println("You already know all quotes by Kanye West . Type 'exit' to close application.");
                command = scanner.nextLine();
                continue;
            }
            if (quotes.contains(quoteText)) {
                continue;
            }
            if (command.equals("next") && !quotes.contains(quoteText) && quotes.size() < quotesListSize) {
                System.out.println(quoteText);
                quotes.add(quoteText);
                command = scanner.nextLine();
                continue;
            } else {
                System.out.println("Wrong command! Type 'next' to see quote by Kanye or 'exit' to close application.");
                command = scanner.nextLine();
            }
        }
    }
}
