package pl.akademiakodu.asocjacje_test_api.dto.mapper;

import org.springframework.stereotype.Component;
import pl.akademiakodu.asocjacje_test_api.dto.QuestionDto;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Answer;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    public QuestionDto mapToQuestionDto(Question question) {
        //QuestionDto musimy stworzyc sami, bo nie jest ono beanem

        QuestionDto questionDto = new QuestionDto(question.getContent());
        questionDto.setId(question.getId());

        List<Answer> answers = question.getAnswers();
        //sposób prostszy z pętlą:
        //List<String> answersName = new ArrayList<>(); // potrzebujemy wyciągnąć tylko name z answer
        //for (int i = 0; i < answersName.size(); i++) { // pętlą dodajemy te namy do listy
         //   answersName.add(answers.get(i).getName());
       // }

        //sposób trudniejszy:
        List<String> answersName2 = answers.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        // poniżej chcemy tylko tresci "name" z answers
        questionDto.setOptions(answersName2);

        String correctAnswer = "";
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isCorrect()) {
                correctAnswer = answers.get(i).getName();
            }
        }
        questionDto.setAnswer(correctAnswer);

        return questionDto;
    }
    //encje przerabiamy na questionDto - do tego służą mappery
    public List<QuestionDto> mapToListQuestionDto(List<Question> questions) {
        return questions.stream()
                .map(question -> mapToQuestionDto(question))
                .collect(Collectors.toList());
    }
}
