package com.restaurant.restaurantservice.infraestructure.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "restaurants",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_restaurants_tax_id",
                        columnNames = "tax_id"
                )
        }
)
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "tax_id", nullable = false, length = 50)
    private String taxId;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(length = 30)
    private String phone;

    @Column(length = 255)
    private String email;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected RestaurantEntity() {
    }

    public RestaurantEntity(
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

    public void setId(UUID id) {
        this.id = id;
    }
}