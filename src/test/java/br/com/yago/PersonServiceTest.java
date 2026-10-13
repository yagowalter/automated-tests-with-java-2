package br.com.yago;

import br.com.yago.service.IPersonService;
import br.com.yago.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    @DisplayName("When Create a Person witch Success should Return a Person Object")
    @Test
     void testCreatePerson_When_Success_ShouldReturnPersonObject() {

        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        
        // Then / Assert
        
    }
}
