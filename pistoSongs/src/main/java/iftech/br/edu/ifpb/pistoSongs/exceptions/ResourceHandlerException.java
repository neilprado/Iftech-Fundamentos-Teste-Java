package iftech.br.edu.ifpb.pistoSongs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceHandlerException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(IsNegativedException.class)
    public ResponseEntity<StandardError> isNegatived(IsNegativedException e, HttpServletRequest request){
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Valor negativo", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
