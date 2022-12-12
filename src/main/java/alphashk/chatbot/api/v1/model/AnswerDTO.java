package alphashk.chatbot.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnswerDTO {
    private String body;

    @JsonProperty("answer_url")
    private String answerUrl;
}
