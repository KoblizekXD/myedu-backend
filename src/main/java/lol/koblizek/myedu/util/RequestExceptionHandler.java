package lol.koblizek.myedu.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ RuntimeException.class })
    protected ResponseEntity<String> handleNotFound(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().body("An error occurred: " + ex.getMessage());
    }
}
