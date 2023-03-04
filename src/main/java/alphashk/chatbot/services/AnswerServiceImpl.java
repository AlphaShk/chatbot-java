package alphashk.chatbot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Scanner;

@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    @Override
    public String getAnswer(String question) {

        String[] command = new String[]{"python3", "/usr/src/app/src/main/java/alphashk/chatbot/python/usage.py", question};
        return executeCommand(command);
    }

    private String executeCommand(String[] command) {
        StringBuilder sb = new StringBuilder();
        log.info("Generating answer...");
        try {
            Process process = Runtime.getRuntime().exec(command);
            sb.append(getOutputs(process.getInputStream()));
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Generated answer: " + sb);
        return sb.toString();
    }

    private String getOutputs(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNextLine()) {
                synchronized (this) {
                    String string = "" + scanner.nextLine() + " ";
                    sb.append(string);
                }
            }
            scanner.close();


        return sb.toString();
    }

}
