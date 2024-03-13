package io.sultanov.adapter.service;

import io.sultanov.feignclients.dto.Coordinate;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    Integer getWeatherData(Coordinate coordinate);
}
