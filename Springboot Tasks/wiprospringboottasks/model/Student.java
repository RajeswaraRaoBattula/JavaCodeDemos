package  com.example.wiprospringboottasks.model;

import java.util.List;

import javax.validation.constraints.*;

public class Student {

    @NotBlank(message = "{firstName.required}")
    @Size(min = 3, max = 30, message = "{firstName.size}")
    private String firstName;

    @NotBlank(message = "{lastName.required}")
    @Size(min = 3, max = 30, message = "{lastName.size}")
    private String lastName;

    @NotBlank(message = "{gender.required}")
    private String gender;

    @NotBlank(message = "{dob.required}")
    private String dob;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.invalid}")
    private String email;

    @NotBlank(message = "{section.required}")
    private String section;

    @NotBlank(message = "{country.required}")
    private String country;

    private boolean firstAttempt;

    @NotEmpty(message = "{subjects.required}")
    private List<String> subjects;

    // Getters and setters omitted for brevity
    // Use Lombok or manually generate them
}
