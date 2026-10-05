package com.restaurant.restaurantservice.presentation.controller;

import com.restaurant.restaurantservice.apllication.service.RestaurantApplicationService;
import com.restaurant.restaurantservice.domain.model.Restaurant;
import com.restaurant.restaurantservice.presentation.dto.CreateRestaurantRequest;
import com.restaurant.restaurantservice.presentation.dto.RestaurantResponse;
import com.restaurant.restaurantservice.presentation.dto.UpdateRestaurantRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantApplicationService restaurantService;

    public RestaurantController(
            RestaurantApplicationService restaurantService
    ) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> create(
            @Valid @RequestBody CreateRestaurantRequest request
    ) {

        Restaurant restaurant = restaurantService.create(
                request.name(),
                request.taxId(),
                request.address(),
                request.phone(),
                request.email()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RestaurantResponse.fromDomain(restaurant));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> findAll() {

        List<RestaurantResponse> restaurants =
                restaurantService.findAll()
                        .stream()
                        .map(RestaurantResponse::fromDomain)
                        .toList();

        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> findById(
            @PathVariable UUID id
    ) {

        Restaurant restaurant = restaurantService.findById(id);

        return ResponseEntity.ok(
                RestaurantResponse.fromDomain(restaurant)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateRestaurantRequest request
    ) {

        Restaurant restaurant = restaurantService.update(
                id,
                request.name(),
                request.taxId(),
                request.address(),
                request.phone(),
                request.email(),
                request.active()
        );

        return ResponseEntity.ok(
                RestaurantResponse.fromDomain(restaurant)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ) {

        restaurantService.delete(id);

        return ResponseEntity.noContent().build();
    }
}