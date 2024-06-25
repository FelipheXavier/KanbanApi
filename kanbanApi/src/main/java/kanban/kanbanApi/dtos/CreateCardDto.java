package kanban.kanbanApi.dtos;

import kanban.kanbanApi.entities.Board;
import kanban.kanbanApi.entities.CardStatus;

public record CreateCardDto(String description, Board board) {
}
