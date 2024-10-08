package com.foodiehaven.reviewservice.service.impl;

import com.foodiehaven.reviewservice.model.Review;
import com.foodiehaven.reviewservice.repository.ReviewRepository;
import com.foodiehaven.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ReviewService interface.
 * Provides concrete implementations for CRUD operations on Review entities.
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review updateReview(Long id, Review reviewDetails) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            Review existingReview = review.get();
            // Update the existing review with new details
            existingReview.setRestaurantName(reviewDetails.getRestaurantName());
            existingReview.setFoodName(reviewDetails.getFoodName());
            existingReview.setRating(reviewDetails.getRating());
            existingReview.setReview(reviewDetails.getReview());
            return reviewRepository.save(existingReview);
        }
        return null;// Return null if the review is not found
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
