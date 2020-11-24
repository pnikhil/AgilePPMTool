package io.fullstackexp.ppm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class ProjectIdException extends RuntimeException {
    public ProjectIdException(String message) {
        super(message);
    }
}
