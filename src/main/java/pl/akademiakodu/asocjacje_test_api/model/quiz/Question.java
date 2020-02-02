package pl.akademiakodu.asocjacje_test_api.model.quiz;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor // bo chemy miec bean mimo że dalej robimy ręcznie konstruktor z parametrem
@Entity

public class Question extends EntityBase{

    @JoinColumn(name = "test_id") // bo wkładamy pole innej klasy
    @ManyToOne // wiele pytan w jednym teście
    private Test test; // enkapsulacja - obiekt innej klasy wkładamy jako pole do innej klasy
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL) // jedno pytanie, wiele odpowiedzi
    private List<Answer> answers = new ArrayList<>();

    public Question(String content) {
        this.content = content;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }
}
