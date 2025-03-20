package nl.hva.my_todo_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MalformedIDException extends RuntimeException {
    public MalformedIDException(String message) {
        super(message);
    }
}
