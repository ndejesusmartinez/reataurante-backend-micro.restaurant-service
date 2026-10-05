package com.restaurant.restaurantservice.infraestructure.persistence.adapter;

import com.restaurant.restaurantservice.domain.model.Restaurant;
import com.restaurant.restaurantservice.domain.port.RestaurantRepository;
import com.restaurant.restaurantservice.infraestructure.persistence.entity.RestaurantEntity;
import com.restaurant.restaurantservice.infraestructure.persistence.repository.RestaurantJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RestaurantRepositoryAdapter implements RestaurantRepository {

    private final RestaurantJpaRepository restaurantJpaRepository;

    public RestaurantRepositoryAdapter(
            RestaurantJpaRepository restaurantJpaRepository
    ) {
        this.restaurantJpaRepository = restaurantJpaRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {

        RestaurantEntity entity = toEntity(restaurant);

        RestaurantEntity savedEntity =
                restaurantJpaRepository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public List<Restaurant> findAll() {

        return restaurantJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Restaurant> findById(UUID id) {

        return restaurantJpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Optional<Restaurant> findByTaxId(String taxId) {

        return restaurantJpaRepository.findByTaxId(taxId)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByTaxId(String taxId) {

        return restaurantJpaRepository.existsByTaxId(taxId);
    }

    @Override
    public void deleteById(UUID id) {

        restaurantJpaRepository.deleteById(id);
    }

    private RestaurantEntity toEntity(Restaurant restaurant) {

        return new RestaurantEntity(
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

    private Restaurant toDomain(RestaurantEntity entity) {

        return new Restaurant(
                entity.getId(),
                entity.getName(),
                entity.getTaxId(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.isActive(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}