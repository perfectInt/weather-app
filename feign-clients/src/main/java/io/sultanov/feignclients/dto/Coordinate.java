package io.sultanov.feignclients.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Coordinate {

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;
}
