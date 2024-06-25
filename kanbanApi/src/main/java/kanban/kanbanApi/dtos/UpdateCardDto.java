package kanban.kanbanApi.dtos;

import kanban.kanbanApi.entities.CardStatus;

public record UpdateCardDto(String description, CardStatus cardStatus) {
}
