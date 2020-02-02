package pl.akademiakodu.asocjacje_test_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.asocjacje_test_api.model.quiz.Test;

@Repository
public interface TestRepository extends CrudRepository <Test,Long> { // jeśli podziedziczymy po JPA Repository to będziemy mieli inne metody niż po CrudeRepository
                                                        //Test - bo tą klasą ma zarządzać interface, drugi parametr to Long id, bo to typ id, którym będziemy się posługiwali

}
