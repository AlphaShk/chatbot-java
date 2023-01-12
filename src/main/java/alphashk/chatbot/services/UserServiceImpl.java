package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.mapper.QuestionMapper;
import alphashk.chatbot.api.v1.mapper.UserMapper;
import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.api.v1.model.UserDTO;
import alphashk.chatbot.domain.Question;
import alphashk.chatbot.domain.User;
import alphashk.chatbot.repositories.QuestionRepository;
import alphashk.chatbot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    static final String URL = "/api/v1/users/";
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;

    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).get());
    }

    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepository.save(user);
        UserDTO returnDto = userMapper.userToUserDTO(savedUser);
        returnDto.setUserUrl(URL + savedUser.getId());

        return returnDto;
    }
    @Override
    public Set<QuestionDTO> getQuestions(UserDTO userDTO) {
        return userDTO.getQuestions();
    }
}
