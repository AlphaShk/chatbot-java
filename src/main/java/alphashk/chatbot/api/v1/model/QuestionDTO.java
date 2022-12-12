package alphashk.chatbot.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class QuestionDTO {

    private Long id;
    private String body;

    private Set<AnswerDTO> answers = new HashSet<>();

    @JsonProperty("question_url")
    private String questionUrl;
}
