package org.azulean.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PositionException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
     String positionRepeated(PositionException ex){
        return ex.getLocalizedMessage();
    }

}
