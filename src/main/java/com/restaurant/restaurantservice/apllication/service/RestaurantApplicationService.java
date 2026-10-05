package com.restaurant.restaurantservice.apllication.service;

import com.restaurant.restaurantservice.domain.model.Restaurant;
import com.restaurant.restaurantservice.domain.port.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantApplicationService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantApplicationService(
            RestaurantRepository restaurantRepository
    ) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant create(
            String name,
            String taxId,
            String address,
            String phone,
            String email
    ) {

        if (restaurantRepository.existsByTaxId(taxId)) {
            throw new IllegalArgumentException(
                    "Ya existe un restaurante con el taxId: " + taxId
            );
        }

        Restaurant restaurant = Restaurant.create(
                name,
                taxId,
                address,
                phone,
                email
        );

        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findAll() {

        return restaurantRepository.findAll();
    }

    public Restaurant findById(UUID id) {

        return restaurantRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Restaurante no encontrado: " + id
                        )
                );
    }

    public Restaurant update(
            UUID id,
            String name,
            String taxId,
            String address,
            String phone,
            String email,
            boolean active
    ) {

        Restaurant restaurant = findById(id);

        restaurantRepository.findByTaxId(taxId)
                .filter(existing -> !existing.getId().equals(id))
                .ifPresent(existing -> {
                    throw new IllegalArgumentException(
                            "Ya existe otro restaurante con el taxId: " + taxId
                    );
                });

        restaurant.update(
                name,
                taxId,
                address,
                phone,
                email,
                active
        );

        return restaurantRepository.save(restaurant);
    }

    public void delete(UUID id) {

        Restaurant restaurant = findById(id);

        restaurantRepository.deleteById(restaurant.getId());
    }
}