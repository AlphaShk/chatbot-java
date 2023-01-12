package alphashk.chatbot.api.v1.mapper;

import alphashk.chatbot.api.v1.model.AnswerDTO;
import alphashk.chatbot.domain.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO answerToAnswerDTO(Answer answer);
}
