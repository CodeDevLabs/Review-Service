package com.deafoodservice.app.reviewservice.repository;

import com.deafoodservice.app.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
