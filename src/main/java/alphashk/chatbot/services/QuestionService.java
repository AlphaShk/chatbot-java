package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.domain.Question;

import java.util.Set;

public interface QuestionService {
    QuestionDTO createNewQuestion(QuestionDTO questionDTO, Long userId);

    Set<AnswerDTO> getAnswers(QuestionDTO questionDTO);
    void saveAnswerForQuestion(Long id, String answerBody);
}
