package com.teja.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.teja.urlshortener.model.Url;
import java.util.List;
import jakarta.persistence.LockModeType;

public interface UrlRepository extends JpaRepository<Url, Long> {
	Url findByShortCode(String shortCode);
	List<Url> findTop5ByOrderByClickCountDesc();

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT u FROM Url u WHERE u.shortCode = :shortCode")
	Url findByShortCodeForUpdate(@Param("shortCode") String shortCode);
}