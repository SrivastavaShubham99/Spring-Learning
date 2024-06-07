package guru.springframework.spring6restmvc.exceptions;

import guru.springframework.spring6restmvc.utility.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/*
This is the way how we can globally handle all the exceptions,
and it will be pick up for the all the controllers.
 */

@ControllerAdvice
public class ControllerExceptions {


    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity notFoundException(){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus("error" + request.getDescription(true));
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        errorResponse.setPath(request.getDescription(false).substring(4)); // Extracting the URI

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}


