package io.sultanov.feignclients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgB {
    private String txt;
    private LocalDateTime createdDt;
    private Integer currentTemp;
}
