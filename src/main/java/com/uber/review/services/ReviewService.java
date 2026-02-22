package com.uber.review.services;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.uber.review.models.Review;
import com.uber.review.repositories.ReviewRepository;

@Service
public class ReviewService implements CommandLineRunner {
	
	private ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// This method will be executed after the application context is loaded
		// You can perform any initialization or setup tasks here
		System.out.println("ReviewService initialized successfully!");
		Review review = Review.builder()
				.content("Great ride, very comfortable!")
				.rating(4.5)
				.build();
		
		reviewRepository.save(review);
		
		List<Review> reviews = reviewRepository.findAll();
		
		for (Review r : reviews) {
			System.out.println("Review ID: " + r.getId());
			System.out.println("Content: " + r.getContent());
			System.out.println("Rating: " + r.getRating());
			System.out.println("Created At: " + r.getCreatedAt());
			System.out.println("Updated At: " + r.getUpdatedAt());
			System.out.println("-----------------------------");
		}
	}
}
