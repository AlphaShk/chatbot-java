package alphashk.chatbot.services;

import java.io.IOException;

public interface AnswerService {
    String getAnswer(String question) throws IOException;
}
