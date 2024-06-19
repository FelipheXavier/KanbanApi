package kanban.kanbanApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Board> boards;
    public User(UUID id, String email, String username,String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;

    }

    public User() {
    }
}
