package io.sultanov.errorhandler.handler;

import io.sultanov.errorhandler.exceptions.ServiceNotAvailableException;
import io.sultanov.errorhandler.exceptions.dto.ErrorBody;
import io.sultanov.errorhandler.exceptions.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ServiceNotAvailableException.class})
    public ResponseEntity<ErrorBody> handleServiceNotAvailableException() {
        return new ResponseEntity<>(new ErrorBody(HttpStatus.SERVICE_UNAVAILABLE.value(), "Service not available at the moment"),
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<ValidationError> handleValidationException(MethodArgumentNotValidException ex) {
        ValidationError errorResponse = new ValidationError(false);
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errorResponse.addError(fieldName, errorMessage);
            }
        });
        return ResponseEntity.unprocessableEntity().body(errorResponse);
    }
}
