package lol.koblizek.myedu.util;

import lol.koblizek.myedu.models.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RequestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ RuntimeException.class })
    protected ResponseEntity<String> handleRuntime(Exception ex, WebRequest request) {
        return ResponseEntity.internalServerError().body("An error occurred: " + ex.getMessage());
    }

    @ExceptionHandler({ BadCredentialsException.class})
    protected ResponseEntity<ErrorModel> handleBadCredentials(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorModel(401, "Unauthorized", "Invalid credentials"));
    }

    @ExceptionHandler({ NoSuchElementException.class})
    protected ResponseEntity<ErrorModel> handleNotFound(Exception ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorModel(404, "Not found", "Specified resource was not found"));
    }
}
