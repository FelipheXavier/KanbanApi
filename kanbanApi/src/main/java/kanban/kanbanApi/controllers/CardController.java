package kanban.kanbanApi.controllers;

import kanban.kanbanApi.dtos.CreateCardDto;
import kanban.kanbanApi.dtos.UpdateCardDto;
import kanban.kanbanApi.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/{id}")
    public ResponseEntity<Void> createCard(@PathVariable String id,
                                      @RequestBody CreateCardDto body){
    cardService.createCard(id,body);
    return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(@PathVariable String id,
                                           @RequestBody UpdateCardDto body){
        cardService.updateCard(id,body);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable String id){
        cardService.deleteCard(id);
        return ResponseEntity.ok().build();
    }
}
