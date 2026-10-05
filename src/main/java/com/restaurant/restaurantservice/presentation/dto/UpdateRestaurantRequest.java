package com.restaurant.restaurantservice.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateRestaurantRequest(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 150, message = "El nombre no puede superar 150 caracteres")
        String name,

        @NotBlank(message = "El NIT es obligatorio")
        @Size(max = 50, message = "El NIT no puede superar 50 caracteres")
        String taxId,

        @NotBlank(message = "La dirección es obligatoria")
        @Size(max = 255, message = "La dirección no puede superar 255 caracteres")
        String address,

        @Size(max = 30, message = "El teléfono no puede superar 30 caracteres")
        String phone,

        @Email(message = "El correo no tiene un formato válido")
        @Size(max = 255, message = "El correo no puede superar 255 caracteres")
        String email,

        @NotNull(message = "El estado activo es obligatorio")
        Boolean active
) {
}