package alphashk.chatbot.api.v1.mapper;

import alphashk.chatbot.domain.Question;
import alphashk.chatbot.api.v1.model.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO questionToQuestionDTO(Question question);
    Question questionDTOToQuestion(QuestionDTO questionDTO);
}
