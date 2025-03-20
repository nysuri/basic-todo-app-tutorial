package nl.hva.my_todo_app.dto;

import java.util.Date;

public record ErrorResponse(String message, Date timeStamp) {

}
