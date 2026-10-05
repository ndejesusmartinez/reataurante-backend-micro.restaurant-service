package com.restaurant.restaurantservice.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Restaurant {

    private UUID id;
    private String name;
    private String taxId;
    private String address;
    private String phone;
    private String email;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Restaurant(
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
        this.id = id;
        this.name = name;
        this.taxId = taxId;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Restaurant create(
            String name,
            String taxId,
            String address,
            String phone,
            String email
    ) {
        LocalDateTime now = LocalDateTime.now();

        return new Restaurant(
                null,
                name,
                taxId,
                address,
                phone,
                email,
                true,
                now,
                now
        );
    }

    public void update(
            String name,
            String taxId,
            String address,
            String phone,
            String email,
            boolean active
    ) {
        this.name = name;
        this.taxId = taxId;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.active = active;
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}