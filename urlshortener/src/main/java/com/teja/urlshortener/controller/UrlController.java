package com.teja.urlshortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.teja.urlshortener.model.Url;
import com.teja.urlshortener.service.UrlService;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<Url> shortenUrl(@RequestBody String originalUrl) {
        Url url = urlService.shortenUrl(originalUrl);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/r/{shortCode}")
    public void redirect(@PathVariable("shortCode") String shortCode,
                         HttpServletResponse response) throws IOException {
        Url url = urlService.getUrlByShortCode(shortCode);
        response.sendRedirect(url.getOriginalUrl());
    }
    @GetMapping("/top5")
    public ResponseEntity<List<Url>> getTop5Urls() {
        List<Url> topUrls = urlService.getTop5Urls();
        return ResponseEntity.ok(topUrls);
    }
}