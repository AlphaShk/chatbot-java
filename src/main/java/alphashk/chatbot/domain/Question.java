package alphashk.chatbot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "questions")
public class Question extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "body")
    private String body;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<Answer> answers = new HashSet<>();

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }
}
