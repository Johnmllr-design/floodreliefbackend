package com;

import jakarta.validation.constraints.NotBlank;

public record NewUserRequest(
    @NotBlank String username,
    @NotBlank String password
) {}