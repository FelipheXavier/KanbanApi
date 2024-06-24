package kanban.kanbanApi.exceptions;

public class TryingToCreateMoreThan5Boards extends RuntimeException{
    public TryingToCreateMoreThan5Boards() {
        super ("You can't to create more Boards");
    }

    public TryingToCreateMoreThan5Boards(String message){
        super(message);
    }
}
