package kanban.kanbanApi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="board_Id")
    private UUID boardId;
    private String name;
    @CreatedDate
    private Instant createAt;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToMany(mappedBy = "board")
    private List<Card> cards;


    public Board() {
    }
}
