package pl.akademiakodu.asocjacje_test_api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    private Long id; // to jest id zapytania do bazy, a nie id w bazie, dlatego nie dziedziczymy z EntityBase
    private String content;
    private List<String> options = new ArrayList<>(); // odpowiedzi nieprawidłowe
    private String answer;

    public QuestionDto(String content) {
        this.content = content;
    }


}
