package com.challenge.api.model;

import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeObject implements Employee {
    @NotNull(message = "uuid cannot be null") private UUID uuid;

    @NotNull(message = "firstName cannot be null") private String firstName;

    @NotNull(message = "lastName cannot be null") private String lastName;

    @NotNull(message = "fullName cannot be null") private String fullName;

    @NotNull(message = "salary cannot be null") private Integer salary;

    @NotNull(message = "age cannot be null") private Integer age;

    @NotNull(message = "jobTitle cannot be null") private String jobTitle;

    @NotNull(message = "email cannot be null") private String email;

    @NotNull(message = "contractHireDate cannot be null") private Instant contractHireDate;

    private Instant contractTerminationDate;
}
