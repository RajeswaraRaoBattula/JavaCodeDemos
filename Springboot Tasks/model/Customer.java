package com.example.validationform.model;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Customer {

    @NotBlank(message = "{customer.name.required}")
    @Size(min = 2, max = 30, message = "{customer.name.size}")
    private String name;

    @NotBlank(message = "{customer.email.required}")
    @Email(message = "{customer.email.valid}")
    private String email;

    @NotNull(message = "{customer.age.required}")
    @Min(value = 18, message = "{customer.age.min}")
    private Integer age;

    @NotBlank(message = "{customer.gender.required}")
    private String gender;

    @NotNull(message = "{customer.birthday.required}")
    private LocalDate birthday;

    @Pattern(
        regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}( x\\d{1,5})?)$",
        message = "{customer.phone.invalid}"
    )
    private String phone;

    // Getters and setters omitted for brevity
}
