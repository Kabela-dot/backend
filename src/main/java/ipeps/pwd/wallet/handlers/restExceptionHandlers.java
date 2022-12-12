package ipeps.pwd.wallet.handlers;

import ipeps.pwd.wallet.exceptions.entityNotFoundException;
import ipeps.pwd.wallet.exceptions.invalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class restExceptionHandlers extends ResponseEntityExceptionHandler {
    @ExceptionHandler(entityNotFoundException.class)
    public ResponseEntity<ErrorDto>handlerException(entityNotFoundException exception, WebRequest webRequest){
              final HttpStatus notFound = HttpStatus.NOT_FOUND;
              final ErrorDto errorDto = ErrorDto.builder()
                .codes(exception.getErreursCodes())
                .httpcode(notFound.value())
                .message(exception.getMessage())
                .build();
       return new ResponseEntity<>(errorDto,notFound);
    }
    @ExceptionHandler(invalidEntityException.class)
    public ResponseEntity<ErrorDto>handleException(invalidEntityException exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
         final ErrorDto errorDto = ErrorDto.builder()
                .codes(exception.getErreursCodes())
                .httpcode(badRequest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto,badRequest);
    }
}

