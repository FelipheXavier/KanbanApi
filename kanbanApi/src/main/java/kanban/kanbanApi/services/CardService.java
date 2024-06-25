package kanban.kanbanApi.services;

import kanban.kanbanApi.dtos.CreateCardDto;
import kanban.kanbanApi.dtos.UpdateCardDto;
import kanban.kanbanApi.entities.Card;
import kanban.kanbanApi.exceptions.BoardNotFoundException;
import kanban.kanbanApi.exceptions.CardNotFoundException;
import kanban.kanbanApi.exceptions.TryingToCreateMoreThan5Cards;
import kanban.kanbanApi.repositories.BoardRepository;
import kanban.kanbanApi.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CardService {

    private CardRepository cardRepository;
    private BoardRepository boardRepository;

    public CardService(CardRepository cardRepository, BoardRepository boardRepository){
        this.cardRepository = cardRepository;
        this.boardRepository = boardRepository;
    }

    public void createCard(String id, CreateCardDto body){
        var boardExists = boardRepository.findById(UUID.fromString(id)).orElseThrow(BoardNotFoundException::new);
        if(boardExists.getCards().size() >= 5){
            throw new TryingToCreateMoreThan5Cards();
        }
        var entity = new Card(
                body.description(),
                boardExists

        );
        cardRepository.save(entity);
    }
    public void updateCard(String id, UpdateCardDto body){
        var cardExist = cardRepository.findById(UUID.fromString(id)).orElseThrow(CardNotFoundException::new);
        if(body.description()!= null){
            cardExist.setDescription(body.description());
        }
        if(body.cardStatus()!=null){
            cardExist.setCardStatus(body.cardStatus());
        }
        cardRepository.save(cardExist);
    }
    public void deleteCard(String id){
        var cardExist = cardRepository.findById(UUID.fromString(id)).orElseThrow(CardNotFoundException::new);
        cardRepository.delete(cardExist);
    }
}
