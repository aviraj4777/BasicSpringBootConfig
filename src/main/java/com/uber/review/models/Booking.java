package com.uber.review.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends BaseModel {
    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;
}
