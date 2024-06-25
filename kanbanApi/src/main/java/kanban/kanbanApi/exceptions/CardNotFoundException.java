package kanban.kanbanApi.exceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(){
        super("Card Not Found");
    }
    public CardNotFoundException(String message){super(message);}
}
