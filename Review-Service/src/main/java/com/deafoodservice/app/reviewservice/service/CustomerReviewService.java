package com.deafoodservice.app.reviewservice.service;

import com.deafoodservice.app.reviewservice.model.Review;
import com.deafoodservice.app.reviewservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CustomerReviewService {

    private final ReviewRepository reviewRepository;
    private final NotificationService notificationService;

    public CustomerReviewService(ReviewRepository reviewRepository, NotificationService notificationService) {
        this.reviewRepository = reviewRepository;
        this.notificationService = notificationService;
    }

    public Review addReview(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        Review savedReview = reviewRepository.save(review);
        notificationService.sendNotification(savedReview);
        return savedReview;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
