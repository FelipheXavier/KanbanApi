package kanban.kanbanApi.repositories;

import kanban.kanbanApi.entities.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatusRepository extends JpaRepository<CardStatus,Long> {
}
