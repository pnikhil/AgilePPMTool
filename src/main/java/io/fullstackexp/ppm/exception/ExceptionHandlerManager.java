package io.fullstackexp.ppm.exception;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@CommonsLog
@ControllerAdvice
public class ExceptionHandlerManager {

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<?> serverInternalErrorExceptionHandler(HttpServletRequest request, ServerErrorException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError()
                        .setCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .setMessage("The server encountered an internal error. Please retry the request."));
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiError()
                        .setCode(HttpStatus.BAD_REQUEST.value())
                        .setMessage(e.getMessage()));
    }

    private void logError(HttpServletRequest request, Exception e) {
        log.error("[URI: " + request.getRequestURI() + "]"
                + "[error: " + e.getMessage() + "]");
    }
}
