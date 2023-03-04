package alphashk.chatbot.controllers.v1;

import alphashk.chatbot.api.v1.model.AnswerSetDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.services.AnswerService;
import alphashk.chatbot.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @PostMapping(value = {"/users/{userId}"})
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerSetDTO createNewQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable Long userId) throws IOException {
        QuestionDTO question = questionService.createNewQuestion(questionDTO, userId);
        questionService.saveAnswerForQuestion(question.getId(), answerService.getAnswer(question.getBody()));

        return AnswerSetDTO.builder().answers(questionService.getAnswers(question)).build();
    }
}
