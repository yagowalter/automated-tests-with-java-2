package br.com.yago;

import br.com.yago.model.Person;
import br.com.yago.service.IPersonService;
import br.com.yago.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @DisplayName("When Create a Person witch Success should Return a Person Object")
    @Test
    void testCreatePerson_When_Success_ShouldReturnPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();

        Person person = new Person(
                "Keith",
                "Moon",
                "Kmoon@email.com.br",
                "Wembley - UK",
                "Male"
        );

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned Null!");
    }
}
