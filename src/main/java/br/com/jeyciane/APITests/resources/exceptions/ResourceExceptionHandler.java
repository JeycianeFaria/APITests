package br.com.jeyciane.APITests.resources.exceptions;

import br.com.jeyciane.APITests.services.exceptions.DataIntegratyViolationException;
import br.com.jeyciane.APITests.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request){
        StandarError error = new StandarError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),exception.getMessage(),request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegratyViolationException.class)
    public ResponseEntity<StandarError> dataIntegratyViolationException(DataIntegratyViolationException exception, HttpServletRequest request){
        StandarError error = new StandarError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),exception.getMessage(),request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
