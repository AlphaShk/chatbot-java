package alphashk.chatbot.controllers.v1;

import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import alphashk.chatbot.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/{id}/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDTO createNewQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable Long id) {
        return questionService.createNewQuestion(questionDTO, id);
    }
    @GetMapping("/questions/{qnid}/answers")
    @ResponseStatus(HttpStatus.OK)
    public Set<AnswerDTO> getAnswerForThisQuestion(@PathVariable Long qnid) {
        QuestionDTO question = questionService.getQuestionById(qnid);
        return questionService.getAnswers(question);
    }
}
