package nl.hva.my_todo_app.config;


import nl.hva.my_todo_app.dto.ErrorResponse;
import nl.hva.my_todo_app.exception.BadRequestException;
import nl.hva.my_todo_app.exception.MalformedIDException;
import nl.hva.my_todo_app.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = {BadRequestException.class, NotFoundException.class, MalformedIDException.class})
    public ResponseEntity<ErrorResponse> handleCustomErrors(RuntimeException ex) {
        System.out.println(ex.getMessage());
        var response = new ErrorResponse(ex.getMessage(), new Date());

        return ResponseEntity.status(getHttpStatus(ex)).body(response);
    }

    private HttpStatus getHttpStatus(RuntimeException exception) {
        return switch (exception) {
            case NotFoundException ex -> HttpStatus.NOT_FOUND;
            case BadRequestException ex -> HttpStatus.BAD_REQUEST;
            case MalformedIDException ex -> HttpStatus.BAD_REQUEST;
            default -> HttpStatus.INTERNAL_SERVER_ERROR;

        };
    }
}
