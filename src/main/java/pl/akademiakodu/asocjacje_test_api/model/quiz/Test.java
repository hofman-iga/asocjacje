package pl.akademiakodu.asocjacje_test_api.model.quiz;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//tworzymy test z wieloma odpowiedziami, wiec zrobimy baze danych one to many
@Entity // tworzymy odpowiednik tabeli, jest to również bean
        //możemy zagnieżdzać encję w encji
@Data
public class Test extends EntityBase { // EntityBase - tam będą id, bo nie chcemy za kazdym razem definiowac id

    private String name;

    public Test(String name) { //tu definiujemy konstruktor parametrowy, wiec bedziemy mogli sami tworzyć obiekt
        this.name = name;
    }

    public Test(){ // tu dajemy też konstruktor bezargumentowy, żeby spełnić warunki beana, żeby Spring mógł sam tworzyć obiekty
    }

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL) //jeden test duzo pytań, kaskada, bo chcemy, żeby przy usuwaniu testu usuwały się też pytania/odpowiedzi
    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question){
        question.setTest(this);
        questions.add(question);
    }
}
