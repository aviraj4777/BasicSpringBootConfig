package com.uber.review.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel {
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review; // One-to-one relationship between Booking and Review

    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;
}
