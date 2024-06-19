package kanban.kanbanApi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CardStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String status;

    public CardStatus(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public CardStatus() {
    }
    public enum Enum{
        TO_DO(1L,"To Do"),
        DOING(2L,"Doing"),
        DONE(3L,"Done");
        Enum(Long id, String status){
            this.id = id;
            this.status = status;
        }
        private Long id;
        private String status;
        public CardStatus toEntity(){
            return  new CardStatus(id, status);
         }
    }
}
