package com.foodiehaven.reviewservice.model;

import jakarta.persistence.*;

/**
 * Represents a review entity in the application.
 * This class is mapped to the "reviews" table in the database.
 */

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String restaurantName;
    private String foodName;
    private int rating;
    private String review;

    // Constructors, getters, and setters
    public Review() {}

    /**
     * Constructs a new Review with the given details.
     */
    public Review(String restaurantName, String foodName, int rating, String review) {
        this.restaurantName = restaurantName;
        this.foodName = foodName;
        this.rating = rating;
        this.review = review;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }
}
