package com.foodiehaven.reviewservice.service;

import com.foodiehaven.reviewservice.model.Review;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Review entities.
 * Defines methods for CRUD operations on reviews.
 */
public interface ReviewService {
    List<Review> getAllReviews();
    Review createReview(Review review);
    Optional<Review> getReviewById(Long id);
    Review updateReview(Long id, Review reviewDetails);
    void deleteReview(Long id);
}
