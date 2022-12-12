package alphashk.chatbot.repositories;

import alphashk.chatbot.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
