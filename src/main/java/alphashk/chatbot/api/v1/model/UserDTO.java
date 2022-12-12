package alphashk.chatbot.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Long  id;
    private String name;

    private Set<QuestionDTO> questions = new HashSet<>();

    @JsonProperty("user_url")
    private String userUrl;
}
