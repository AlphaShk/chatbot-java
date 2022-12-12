package alphashk.chatbot.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Column(name = "body") // #todo probability of a good answer
    private String body;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
