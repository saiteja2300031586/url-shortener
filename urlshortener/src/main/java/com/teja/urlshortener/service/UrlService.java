package com.teja.urlshortener.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.teja.urlshortener.model.Url;
import com.teja.urlshortener.repository.UrlRepository;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url shortenUrl(String originalUrl) {
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setExpiresAt(LocalDateTime.now().plusDays(30));
        url = urlRepository.save(url);
        String shortCode = generateShortCode(url.getId());
        url.setShortCode(shortCode);
        url = urlRepository.save(url);
        return url;
    }

    private String generateShortCode(Long id) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortCode = new StringBuilder();
        while (id > 0) {
            shortCode.append(chars.charAt((int)(id % 62)));
            id /= 62;
        }
        return shortCode.reverse().toString();
    }

    @Transactional
    public Url getUrlByShortCode(String shortCode) {
    	Url url = urlRepository.findByShortCodeForUpdate(shortCode);
        if (url == null) {
            throw new UrlNotFoundException("URL not found");
        }
        if (url.getExpiresAt() != null && url.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new UrlExpiredException("URL has expired");
        }
        url.setClickCount(url.getClickCount() + 1);
        urlRepository.save(url);
        return url;
    }

    public List<Url> getTop5Urls() {
        return urlRepository.findTop5ByOrderByClickCountDesc();
    }
}