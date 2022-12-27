package group.crisalis.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
import group.crisalis.exception.custom.NotFoundException;
import group.crisalis.exception.custom.UnauthorizedException;

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

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({
        UnauthorizedException.class
    })
    @ResponseBody
    public void unauthorized() {
        //http 401 no retorna nada
        
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
        NotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFound(HttpServletRequest request,Exception exception) {
        return new ErrorMessage(exception,request.getRequestURI());
    }


}
