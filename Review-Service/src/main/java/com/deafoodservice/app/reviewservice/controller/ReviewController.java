package com.deafoodservice.app.reviewservice.controller;

import com.deafoodservice.app.reviewservice.model.Review;
import com.deafoodservice.app.reviewservice.service.CustomerReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final CustomerReviewService customerReviewService;

    public ReviewController(CustomerReviewService customerReviewService) {
        this.customerReviewService = customerReviewService;
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return customerReviewService.addReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return customerReviewService.getAllReviews();
    }
}
