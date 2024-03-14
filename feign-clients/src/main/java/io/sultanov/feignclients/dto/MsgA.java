package io.sultanov.feignclients.dto;

import io.sultanov.feignclients.dto.Coordinate;
import io.sultanov.feignclients.util.Language;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MsgA {

    @NotEmpty
    private String msg;

    @NotNull
    private Language lng;

    @Valid
    private Coordinate coordinates;
}
