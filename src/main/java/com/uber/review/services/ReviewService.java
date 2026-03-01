package com.uber.review.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.uber.review.models.Booking;
import com.uber.review.models.Review;
import com.uber.review.repositories.BookingRepository;
import com.uber.review.repositories.ReviewRepository;

@Service
public class ReviewService implements CommandLineRunner {
	
	private ReviewRepository reviewRepository;
	private BookingRepository bookingRepository;
	
	// Constructor-based dependency injection- Spring will automatically inject the required dependencies when creating an instance of ReviewService
	// Scans the application context for beans of type ReviewRepository and BookingRepository and injects them into the constructor
	public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
		this.reviewRepository = reviewRepository;
		this.bookingRepository = bookingRepository;
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

		Booking b = Booking.builder().review(review).endTime(LocalDateTime.now()).build();

		bookingRepository.save(b);
		
		// reviewRepository.save(review);
		
		List<Review> reviews = reviewRepository.findAll();
		
		for (Review r : reviews) {
			System.out.println("Review ID: " + r.getId());
			System.out.println("Content: " + r.getContent());
			System.out.println("Rating: " + r.getRating());
			System.out.println("Created At: " + r.getCreatedAt());
			System.out.println("Updated At: " + r.getUpdatedAt());
			System.out.println("-----------------------------");
		}

		// This will delete the booking with ID 1, which will also delete the associated review due to the one-to-one relationship and cascade settings.
		// Optional<Booking> optionalBooking = bookingRepository.findById(1L);
		// if(optionalBooking.isPresent()) {
		// 	bookingRepository.delete(optionalBooking.get());
		// 	System.out.println("Booking with ID 1 deleted successfully.");
		// }

		// This can't be performed because you can't delete a review without deleting the booking first because of the one-to-one relationship between Booking and Review.
		// Optional<Review> optionalReview = reviewRepository.findById(1L);
		// if(optionalReview.isPresent()) {
		// 	reviewRepository.delete(optionalReview.get());
		// 	System.out.println("Review with ID 1 deleted successfully.");
		// }
	}
}
