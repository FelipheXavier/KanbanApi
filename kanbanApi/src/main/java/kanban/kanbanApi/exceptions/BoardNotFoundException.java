package kanban.kanbanApi.exceptions;


public class BoardNotFoundException extends RuntimeException{
    public BoardNotFoundException(){
        super("Board not found");
    }
    public BoardNotFoundException(String message){super(message);}
}
