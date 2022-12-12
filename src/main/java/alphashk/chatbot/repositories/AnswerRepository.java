package alphashk.chatbot.repositories;

import alphashk.chatbot.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
