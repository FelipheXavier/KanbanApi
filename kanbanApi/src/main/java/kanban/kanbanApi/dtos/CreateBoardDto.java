package kanban.kanbanApi.dtos;

import kanban.kanbanApi.entities.Card;
import kanban.kanbanApi.entities.User;

import java.util.List;
import java.util.UUID;

public record CreateBoardDto(String name) {
}
