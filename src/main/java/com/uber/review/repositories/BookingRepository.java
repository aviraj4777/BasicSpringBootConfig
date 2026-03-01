package com.uber.review.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uber.review.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
