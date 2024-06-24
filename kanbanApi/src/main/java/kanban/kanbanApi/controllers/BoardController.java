package kanban.kanbanApi.controllers;

import kanban.kanbanApi.dtos.CreateBoardDto;
import kanban.kanbanApi.dtos.UpdateBoardDto;
import kanban.kanbanApi.entities.User;
import kanban.kanbanApi.exceptions.TryingToCreateMoreThan5Boards;
import kanban.kanbanApi.services.BoardService;
import kanban.kanbanApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;
    private UserService userService;
    public BoardController(BoardService boardService, UserService userService) {
        this.boardService= boardService;
        this.userService = userService;
    }



    @PostMapping("/{id}")
    public ResponseEntity<Void> createBoard(@PathVariable String id,
                                            @RequestBody CreateBoardDto body) {
        boardService.createBoard(id,body);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable String id){
        boardService.deleteBoard(id);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBoard(@PathVariable String id,
                                            @RequestBody UpdateBoardDto body){
        boardService.updateBoard(id,body);
        return ResponseEntity.status(200).build();
    }
}
