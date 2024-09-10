package com.foodiehaven.reviewservice.controller;

import com.foodiehaven.reviewservice.model.Review;
import com.foodiehaven.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling Review-related HTTP requests.
 * Provides endpoints for CRUD operations on reviews.
 */
@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "http://localhost:3000")// Allows cross-origin requests from the React frontend
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    /**
     * Retrieves all reviews.
     * @return ResponseEntity containing a list of all reviews
     */
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    /**
     * Creates a new review.
     * @param review The review to be created
     * @return ResponseEntity containing the created review
     */
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.CREATED);
    }

    /**
     * Retrieves a specific review by its ID.
     * @param id The ID of the review to retrieve
     * @return ResponseEntity containing the requested review, or a not found status
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing review.
     * @param id The ID of the review to update
     * @param reviewDetails The updated review details
     * @return ResponseEntity containing the updated review, or a not found status
     */
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Review updatedReview = reviewService.updateReview(id, reviewDetails);
        return updatedReview != null ? ResponseEntity.ok(updatedReview) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes a review by its ID.
     * @param id The ID of the review to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().build();
    }
}
