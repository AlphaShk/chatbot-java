package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.mapper.AnswerMapper;
import alphashk.chatbot.api.v1.mapper.QuestionMapper;
import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.domain.Answer;
import alphashk.chatbot.domain.Question;
import alphashk.chatbot.domain.User;
import alphashk.chatbot.repositories.QuestionRepository;
import alphashk.chatbot.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    static final String URL = "/api/v1/questions/";
    private final QuestionMapper questionMapper;
    private final AnswerMapper answerMapper;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;


    public QuestionServiceImpl(QuestionMapper questionMapper, AnswerMapper answerMapper, QuestionRepository questionRepository, UserRepository userRepository) {
        this.questionMapper = questionMapper;
        this.answerMapper = answerMapper;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;

    }

    @Override
    @Transactional
    public QuestionDTO createNewQuestion(QuestionDTO questionDTO, Long id) {
        Question question = questionMapper.questionDTOToQuestion(questionDTO);

        User user = userRepository.findById(id).get();
        question.setUser(user);
        user.getQuestions().add(question);

        questionRepository.save(question);

        QuestionDTO returnDTO = questionMapper.questionToQuestionDTO(question);

        returnDTO.setQuestionUrl(URL + question.getId());

        return returnDTO;
    }


    @Override
    public Set<AnswerDTO> getAnswers(QuestionDTO questionDTO) {
        return  questionRepository.findById(questionDTO.getId()).get().getAnswers().stream().map(answerMapper::answerToAnswerDTO).collect(Collectors.toSet()); // #todo optional unwrapping
    }

    @Override
    @Transactional
    public void saveAnswerForQuestion(Long id, String answerBody) {

        Question question = questionRepository.findById(id).get();
        Answer answer = Answer.builder().body(answerBody).build();

        question.addAnswer(answer);

        questionRepository.save(question);
    }

}
