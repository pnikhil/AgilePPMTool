package io.fullstackexp.ppm.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)

@Getter
@Setter
@ToString
public class ApiError {
    private int code;
    private String message;
}