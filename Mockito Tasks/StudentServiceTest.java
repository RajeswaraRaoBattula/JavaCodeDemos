/*
 * Scenario: You have a StudentService that uses StudentRepository.

Mock StudentRepository

When findById(1) is called, return a dummy Student

Verify if StudentService.getStudentById(1) returns the expected name
 */


package mymockitodemos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    public void testGetStudentById_ReturnsExpectedName() {
        // Arrange
        Student dummyStudent = new Student(1, "John Doe");
        when(studentRepository.findById(1)).thenReturn(dummyStudent);

        // Act
        String name = studentService.getStudentById(1);

        // Assert
        assertEquals("John Doe", name);
        verify(studentRepository, times(1)).findById(1);
    }
}
