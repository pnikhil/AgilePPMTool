package io.fullstackexp.ppm.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)

@Data
@ToString
public class ApiError {
    private int code;
    private String message;
}