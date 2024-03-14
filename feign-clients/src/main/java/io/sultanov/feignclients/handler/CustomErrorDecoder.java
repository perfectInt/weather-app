package io.sultanov.feignclients.handler;

import feign.Response;
import feign.codec.ErrorDecoder;
import io.sultanov.errorhandler.exceptions.ServiceNotAvailableException;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (responseStatus == HttpStatus.SERVICE_UNAVAILABLE) {
            return new ServiceNotAvailableException();
        } else {
            return new Exception("Generic exception");
        }
    }
}