package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.api.v1.model.UserDTO;

import java.util.Set;

public interface UserService {
    Set<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createNewUser(UserDTO userDTO);
    Set<QuestionDTO> getQuestions(UserDTO userDTO);
}
