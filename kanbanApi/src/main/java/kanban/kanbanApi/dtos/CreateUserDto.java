package kanban.kanbanApi.dtos;

import kanban.kanbanApi.entities.Board;

import java.util.List;

public record CreateUserDto(String username, String email, String password) {
}
