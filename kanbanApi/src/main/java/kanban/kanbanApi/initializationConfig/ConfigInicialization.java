package kanban.kanbanApi.initializationConfig;

import kanban.kanbanApi.entities.CardStatus;
import kanban.kanbanApi.repositories.CardStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ConfigInicialization implements CommandLineRunner {


    private final CardStatusRepository cardStatusRepository;
    public ConfigInicialization(CardStatusRepository cardStatusRepository){
        this.cardStatusRepository = cardStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Arrays.stream(CardStatus.Enum.values()).forEach(CardStatus->cardStatusRepository.save(CardStatus.toEntity()));
    }
}
