package kanban.kanbanApi.controllers;

import kanban.kanbanApi.dtos.CreateUserDto;
import kanban.kanbanApi.dtos.UpdateUserDto;
import kanban.kanbanApi.entities.User;
import kanban.kanbanApi.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto body){
        var userId = userService.createNewUser(body);
        return ResponseEntity.created(URI.create("user/"+userId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        var user = userService.getUserById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable String id,
                                               @RequestBody UpdateUserDto body){
        userService.updateUserById(id ,body);
        return ResponseEntity.noContent().build();
    }
}
