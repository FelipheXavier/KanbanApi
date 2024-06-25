package kanban.kanbanApi.exceptions;

public class TryingToCreateMoreThan5Cards  extends  RuntimeException{
    public TryingToCreateMoreThan5Cards (){
        super("You Can't create more than 5 cards");
    }
}
