package kg.backend.java.Dordoi.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {
    private String message;
    private HttpStatus httpStatus;

    public ApiResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
