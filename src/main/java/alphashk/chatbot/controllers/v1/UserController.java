package alphashk.chatbot.controllers.v1;

import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.api.v1.model.UserDTO;
import alphashk.chatbot.services.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/questions")
    @ResponseStatus(HttpStatus.OK)
    public Set<QuestionDTO> getQuestionsByUser(@PathVariable Long id) {
        return userService.getQuestions(userService.getUserById(id));
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createNewUser(@RequestBody UserDTO userDTO) {
        return userService.createNewUser(userDTO);
    }


}
