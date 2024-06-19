package kanban.kanbanApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID card_Id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "board_Id")
    private Board board;

    public Card() {
    }

    @ManyToOne
    @JoinColumn(name = "card_status_Id")
    private CardStatus cardStatus;
}
