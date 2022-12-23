package group.crisalis.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;


@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        EmptyElementException.class,
        NotCreatedException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request,Exception exception){
        return new ErrorMessage(exception, request.getRequestURI());
    }
}
