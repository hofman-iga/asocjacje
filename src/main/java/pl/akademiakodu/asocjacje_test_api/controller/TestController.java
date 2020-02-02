package pl.akademiakodu.asocjacje_test_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.asocjacje_test_api.dto.TestDto;
import pl.akademiakodu.asocjacje_test_api.dto.mapper.TestMapper;
import pl.akademiakodu.asocjacje_test_api.repository.TestRepository;

@RestController // klasa zwracająca JSONa
@CrossOrigin // pozwala na nieblokowanie ruchu z zewnątrz
@RequestMapping("/tests") // główna ścieżka, którą musimy wklepać przed dalszą ścieżką np. na GetMapping// kazde zapytanie z /tests trafi do tej klasy TestController
public class TestController {

    @Autowired // wstrzykujemy testMappera - tu musimy jeszcze stworzyc beana z testMappera (testMapper musi być beanem)
    private TestMapper testMapper;

    @Autowired // wstrzykujemy testRepository (który musi być beanem)
    private TestRepository testRepository;

    @GetMapping("/{id}") // http://localhost:8080/tests/id


    public TestDto sayHello(@PathVariable Long id){ //id będzie sPARSOWANA do Longa
        return testMapper.mapToTestDto(testRepository.findById(id).get());
    }


}
