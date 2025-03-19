package nl.hva.my_todo_app.config;

import nl.hva.my_todo_app.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

//    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
//        var response = new ErrorResponse();
//        return ResponseEntity<>()
//    }
}
