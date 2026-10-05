package com.restaurant.restaurantservice.domain.port;

import com.restaurant.restaurantservice.domain.model.Restaurant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    List<Restaurant> findAll();

    Optional<Restaurant> findById(UUID id);

    Optional<Restaurant> findByTaxId(String taxId);

    boolean existsByTaxId(String taxId);

    void deleteById(UUID id);
}
