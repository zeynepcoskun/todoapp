package com.todoapp.model;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * User Entity
 *
 */
@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "{warning.firstname.empty}")
    @Pattern(message = "User name can only contain letters", regexp = "[a-zA-Z_.]*")
    private String firstName;

    @NotBlank(message = "{warning.lastName.empty}")
    @Pattern(message = "User last name can only contain letters", regexp = "[a-zA-Z_.]*")
    private String lastName;

    @NotBlank(message = "{warning.title.empty}")
    private String title;

    @NotBlank(message = "{warning.email.empty}")
    @Column(unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Todo> todos;

}
