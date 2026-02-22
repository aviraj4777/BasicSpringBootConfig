package com.uber.review.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uber.review.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {


}
