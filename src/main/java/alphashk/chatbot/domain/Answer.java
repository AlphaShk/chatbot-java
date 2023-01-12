package alphashk.chatbot.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
