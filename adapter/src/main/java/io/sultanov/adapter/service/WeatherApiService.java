package io.sultanov.adapter.service;

import com.jayway.jsonpath.JsonPath;
import io.sultanov.errorhandler.exceptions.ServiceNotAvailableException;
import io.sultanov.feignclients.dto.Coordinate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherApiService implements WeatherService {

    private final RestTemplate restTemplate;
    @Value("${weather.weather-api.url}")
    private String url;

    @Override
    public Integer getWeatherData(Coordinate coordinate) {
        try {
            String response = restTemplate.getForObject(url +
                    String.format("%s,%s", coordinate.getLatitude(), coordinate.getLongitude()), String.class);

            Double currentTemp = JsonPath.read(response, "$.current.temp_c");
            return currentTemp.intValue();
        } catch (ResourceAccessException e) {
            throw new ServiceNotAvailableException("Timeout while fetching weather data", e);
        }
    }
}
