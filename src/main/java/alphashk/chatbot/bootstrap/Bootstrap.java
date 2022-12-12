package alphashk.chatbot.bootstrap;

import alphashk.chatbot.domain.Question;
import alphashk.chatbot.domain.User;
import alphashk.chatbot.repositories.QuestionRepository;
import alphashk.chatbot.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public Bootstrap(UserRepository userRepository, QuestionRepository questionRepository) {
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        Question question1 = new Question();
        Question question2 = new Question();

        user1.setName("Jack");
        question1.setBody("Was beeinflussen Wechselwirkungen?");
        question2.setBody("Was ist Ableitung?");

        question1.setUser(user1);
        question2.setUser(user1);

        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);

        user1.setQuestions(questions);

        userRepository.save(user1);

        questionRepository.save(question1);
        questionRepository.save(question2);

        System.out.println("saved");
    }
}
