package com.restaurant.restaurantservice.presentation.dto;

import com.restaurant.restaurantservice.domain.model.Restaurant;

import java.time.LocalDateTime;
import java.util.UUID;

public record RestaurantResponse(
        UUID id,
        String name,
        String taxId,
        String address,
        String phone,
        String email,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static RestaurantResponse fromDomain(Restaurant restaurant) {

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getTaxId(),
                restaurant.getAddress(),
                restaurant.getPhone(),
                restaurant.getEmail(),
                restaurant.isActive(),
                restaurant.getCreatedAt(),
                restaurant.getUpdatedAt()
        );
    }
}