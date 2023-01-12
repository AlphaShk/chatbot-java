package alphashk.chatbot.api.v1.model;


import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class AnswerSetDTO {
    private Set<AnswerDTO> answers;
}
