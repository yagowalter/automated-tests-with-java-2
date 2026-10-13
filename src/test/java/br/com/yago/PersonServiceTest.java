package br.com.yago;

import br.com.yago.model.Person;
import br.com.yago.service.IPersonService;
import br.com.yago.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    IPersonService service;
    Person person;

    @BeforeEach
    void setup() {
        service = new PersonService();
        person = new Person(
                "Moon",
                "Keith",
                "Wembley - UK",
                "Male",
                "Kmoon@email.com.br"
        );
    }

    @DisplayName("When Create a Person witch Success should Return a Person Object")
    @Test
    void testCreatePerson_When_Success_ShouldReturnPersonObject() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned Null!");
    }


    @DisplayName("When Create a Person witch Success should contains Valid Fields in Returned a Person Object")
    @Test
    void testCreatePerson_When_Success_ShouldContainsValidFieldsInReturnedPersonObject() {

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(person.getId(), () -> "Person ID is missing!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The FirstName is Incorrect!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The address is Incorrect!");
        assertEquals(person.getGender(), actual.getGender(), () -> "The gender is Incorrect!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The lastName is Incorrect!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The email is Incorrect!");
    }

    @DisplayName("When Create a Person with null email should throw Exception")
    @Test
    void testCreatePerson_WhitNullEmail_ShouldThrowIllegalArgumentException() {

        // Given / Arrange
        person.setEmail(null);

        var expectedMessage = "The Person email is null or empty!";

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty email should have caused an IllegalArgumentException"
        );
        assertEquals(expectedMessage, exception.getMessage(),
                () -> "Exception error message is incorrect!");
    }
}
