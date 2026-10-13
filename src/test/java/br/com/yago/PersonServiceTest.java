package br.com.yago;

import br.com.yago.model.Person;
import br.com.yago.service.IPersonService;
import br.com.yago.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
        person = new Person(
                "Keith",
                "Moon",
                "Kmoon@email.com.br",
                "Wembley - UK",
                "Male"
        );
    }

    @DisplayName("When Create a Person witch Success should Return a Person Object")
    @Test
    void testCreatePerson_When_Success_ShouldReturnPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned Null!");
    }


    @DisplayName("When Create a Person witch Success should contains FirstName in Returned a Person Object")
    @Test
    void testCreatePerson_When_Success_ShouldContainsFirstNameInReturnedPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The FirstName is different!");
    }
}
