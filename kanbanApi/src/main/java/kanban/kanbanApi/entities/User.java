package kanban.kanbanApi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(unique = true)
    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
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
