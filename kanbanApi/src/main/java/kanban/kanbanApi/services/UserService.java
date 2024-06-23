package kanban.kanbanApi.services;

import kanban.kanbanApi.dtos.CreateBoardDto;
import kanban.kanbanApi.dtos.CreateUserDto;
import kanban.kanbanApi.dtos.UpdateUserDto;
import kanban.kanbanApi.entities.Board;
import kanban.kanbanApi.entities.User;
import kanban.kanbanApi.exceptions.TryingToCreateMoreThan5Boards;
import kanban.kanbanApi.repositories.BoardRepository;
import kanban.kanbanApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userRepository;
    private BoardRepository boardRepository;

    public UserService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public UUID createNewUser(CreateUserDto body){
        var userEntity = new User(UUID.randomUUID(),body.email(),body.username(),body.password());
        var userSaved = userRepository.save(userEntity);
        return userSaved.getId();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id){
         return userRepository.findById(UUID.fromString(id));
    }

    public void deleteUserById(String id){
        var stringId = UUID.fromString(id);
        var user = userRepository.findById(stringId);
        if(user.isPresent()){
            userRepository.deleteById(stringId);
        }
    }
    public void updateUserById(String id, UpdateUserDto body){
        var stringId = UUID.fromString(id);
        var userVerify = userRepository.findById(stringId);
        if(userVerify.isPresent()){
            var user = userVerify.get();
            if(body.username() != null){
                user.setUsername(body.username());
            }
            if(body.password() != null){
                user.setPassword(body.password());
            }
            userRepository.save(user);
        }
    }


}
