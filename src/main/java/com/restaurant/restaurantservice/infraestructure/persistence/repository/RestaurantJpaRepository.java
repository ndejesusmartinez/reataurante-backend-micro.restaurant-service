package com.restaurant.restaurantservice.infraestructure.persistence.repository;

import com.restaurant.restaurantservice.infraestructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity, UUID> {

    Optional<RestaurantEntity> findByTaxId(String taxId);

    boolean existsByTaxId(String taxId);
}