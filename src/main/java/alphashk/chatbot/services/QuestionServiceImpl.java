package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.mapper.QuestionMapper;
import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.domain.Question;
import alphashk.chatbot.domain.User;
import alphashk.chatbot.repositories.QuestionRepository;
import alphashk.chatbot.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {
    static final String URL = "/api/v1/questions/";
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionMapper questionMapper, QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionMapper = questionMapper;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public QuestionDTO getQuestionById(Long id) {
        return questionMapper.questionToQuestionDTO(questionRepository.findById(id).orElse(new Question()));
    }

    @Override
    public QuestionDTO createNewQuestion(QuestionDTO questionDTO, Long id) {
        Question question = questionMapper.questionDTOToQuestion(questionDTO);
        Question savedQuestion = questionRepository.save(question);
        QuestionDTO returnDTO = questionMapper.questionToQuestionDTO(savedQuestion);

        Optional<User> user = userRepository.findById(id);
        user.get().getQuestions().add(savedQuestion);
        User _ = userRepository.save(user.get());
        returnDTO.setQuestionUrl(URL + savedQuestion.getId());

        return returnDTO;
    }

    @Override
    public Set<AnswerDTO> getAnswers(QuestionDTO questionDTO) {
        return questionDTO.getAnswers();
    }
}
