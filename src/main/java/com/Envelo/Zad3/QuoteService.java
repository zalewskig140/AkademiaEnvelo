package com.Envelo.Zad3;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuoteService {
    private final RestTemplate restTemplate;

    public QuoteService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        this.restTemplate.setMessageConverters(messageConverters);
    }


    public Quote getKayneQuote() {
        Quote quote = this.restTemplate.getForEntity("https://api.kanye.rest", Quote.class).getBody();
        return quote;
    }


    public int qetQuotesListSize() {
        List<String> quotesList = this.restTemplate.getForEntity("https://raw.githubusercontent.com/ajzbc/kanye.rest/master/quotes.json", List.class).getBody();
        return quotesList.size();
    }

}
