package kanban.kanbanApi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;
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
    @CreationTimestamp
    private LocalDate createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Card> cards;

    public Board(UUID boardId,String name, Date createAt,User user, List<Card> cards) {
        this.boardId = boardId;
        this.name = name;
        this.user = user;
        this.cards = cards;
    }

    public Board() {
    }
}
