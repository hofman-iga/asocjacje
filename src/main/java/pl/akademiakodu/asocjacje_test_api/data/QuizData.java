package pl.akademiakodu.asocjacje_test_api.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Answer;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Question;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Test;
import pl.akademiakodu.asocjacje_test_api.repository.TestRepository;

@Component
public class QuizData implements CommandLineRunner { // implementacja CommandLineRunner daje nam to, że ta klasa implementuje metode run i jest klasą uruchomieniowa

    @Autowired //dependency injection; wstrzykujemy testRepository
    TestRepository testRepository;

    @Override
    public void run(String... args) throws Exception {

        Test test = new Test("About everything");
        Question question = new Question("What is The Capital of Poland");
        question.addAnswer(new Answer("Warsaw",true));
        question.addAnswer(new Answer("Mumbai",false));
        question.addAnswer(new Answer("Kolkatta",false));Question question2 = new Question("Who is CEO of Tesla Motors?");
        question2.addAnswer(new Answer("Bill Gates",false));
        question2.addAnswer(new Answer("Steve Jobs",false));
        question2.addAnswer(new Answer("Elon Musk",true));Question question3 = new Question("Name World's Richest Man?");


        test.addQuestion(question);
        test.addQuestion(question2);
        test.addQuestion(question3);


        testRepository.save(test);

    }
}
