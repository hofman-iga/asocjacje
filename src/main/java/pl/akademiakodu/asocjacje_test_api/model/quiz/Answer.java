package pl.akademiakodu.asocjacje_test_api.model.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
public class Answer extends EntityBase {

    private String name;
    private boolean correct;

    @JoinColumn(name = "question_id")
    @ManyToOne
    private Question question;

    public Answer(String name, boolean correct){
        this.name = name;
        this.correct = correct;
    }

    public boolean isCorrect(){ //tu definiujemy getter, bo z automatu przez @Data w przypadku boolean nazwy gettera mogą być różne w zależności od wersji lomboka
        return correct;
    }


}
