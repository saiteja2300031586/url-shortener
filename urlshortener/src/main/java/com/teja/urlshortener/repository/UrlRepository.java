package com.teja.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teja.urlshortener.model.Url;
import java.util.List;

public interface UrlRepository extends JpaRepository<Url,Long>{
	Url findByShortCode(String shortCode);
	List<Url> findTop5ByOrderByClickCountDesc();
}
