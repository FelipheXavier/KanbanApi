package kanban.kanbanApi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandle {
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
    @ExceptionHandler(TryingToCreateMoreThan5Boards.class)
    private ResponseEntity<String> TryingToCreateMoreThan5boards(TryingToCreateMoreThan5Boards exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You Can't to create more boards");
    }
    @ExceptionHandler(BoardNotFoundException.class)
    private ResponseEntity<String> BoardNotFound(BoardNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found");
    }

}
