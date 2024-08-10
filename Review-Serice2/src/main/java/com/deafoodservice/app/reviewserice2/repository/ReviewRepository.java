package com.deafoodservice.app.reviewserice2.repository;

import com.deafoodservice.app.reviewserice2.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
