package pl.akademiakodu.asocjacje_test_api.model.quiz;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data //// tworzy gettery, settery, equals, hashCode, toString oraz konstruktory jednoargumentowe z każdym polem
@MappedSuperclass // adnotacja, która pozwala na mapowanie tej klasy w momencie, gdy mapujemy klasę dziecko (klasę dziedziczącą), w tym wypadku Test
public class EntityBase { // ta klasa jest po to, żeby mieć Id w każdej tabeli bez tworzenia tego w kazdej tabeli
                            // jest też po to, że jak chcemy dodac nowe pole do kazdej tabeli to dodamy je tylko tu

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
}
