package pl.akademiakodu.asocjacje_test_api.dto.mapper;

import org.springframework.stereotype.Component;
import pl.akademiakodu.asocjacje_test_api.dto.TestDto;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Test;
@Component
public class TestMapper {


    private QuestionMapper questionMapper = new QuestionMapper();

    public TestDto mapToTestDto(Test test) {
        TestDto testDto = new TestDto();

        testDto.setName(test.getName());
        testDto.setQuestions(questionMapper.mapToListQuestionDto(test.getQuestions()));
        return testDto;

    }
}
