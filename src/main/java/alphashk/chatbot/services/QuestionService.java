package alphashk.chatbot.services;

import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;

import java.util.Set;

public interface QuestionService {
    QuestionDTO getQuestionById(Long id);
    QuestionDTO createNewQuestion(QuestionDTO questionDTO, Long id);

    Set<AnswerDTO> getAnswers(QuestionDTO questionDTO);
}
