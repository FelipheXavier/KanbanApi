package kanban.kanbanApi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Board board;

    public Card() {
    }
    public Card(String description, Board board){
        this.description = description;
        this.board = board;
        this.cardStatus = CardStatus.Enum.TO_DO.toEntity();
    }
    @ManyToOne
    @JoinColumn(name = "card_status_Id")
    private CardStatus cardStatus;
}
