package kanban.kanbanApi.services;

import kanban.kanbanApi.dtos.CreateBoardDto;
import kanban.kanbanApi.entities.Board;
import kanban.kanbanApi.exceptions.TryingToCreateMoreThan5Boards;
import kanban.kanbanApi.exceptions.UserNotFoundException;
import kanban.kanbanApi.repositories.BoardRepository;
import kanban.kanbanApi.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.UUID;


@Service
public class BoardService {
    private BoardRepository boardRepository;
    private UserRepository userRepository;
    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }
    public void createBoard(String id, CreateBoardDto body){
        var userExists = userRepository.findById(UUID.fromString(id)).orElseThrow(UserNotFoundException::new);
        if(userExists.getBoards().size()>=5){
            throw new TryingToCreateMoreThan5Boards();
        }
        var boardEntity = new Board(null,
                body.name(),
                null,
                userExists,
                new ArrayList<>());
        var boardCreated = boardRepository.save(boardEntity);

    }
}
