package org.example.exreposeitory.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(10) not null")

    @Size(min = 4 ,message = "name most by Length more than 4 ")
    @NotEmpty(message = "name most by not empty")
    private String name;

    @Column(columnDefinition = "varchar (10) not null unique")

    @Size(min = 4 ,message = "username most by Length more than 4 ")
    @NotEmpty(message = "username cannot by not empty")
    private String userName;

    @Column(columnDefinition = "varchar not null")

    @NotEmpty(message = "password most by not empty")
    private String password;

    @Column(columnDefinition = "varchar (20) not null unique")

    @Email(message = "email most be valid")
    @NotEmpty(message = "email most by not empty")
    private String email;

    @Column(columnDefinition = "varchar(5) not null ")

    @Pattern(regexp = "user|admin")
    @NotEmpty(message = "role most by not empty")
    private String role;

    @Column(columnDefinition = " int not null")

    @NotNull(message = "age most by not null")
    private Integer age;


}
