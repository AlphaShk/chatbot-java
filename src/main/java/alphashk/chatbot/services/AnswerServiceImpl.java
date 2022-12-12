package alphashk.chatbot.services;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Override
    public String getAnswer(String question) {
        System.out.println("Getting the answer"); // #todo logic and communication with the Python NN
        return "This is Answer";
    }
}
