package com.foodiehaven.reviewservice.repository;

import com.foodiehaven.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Review entities.
 * Extends JpaRepository to inherit basic CRUD operations.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
