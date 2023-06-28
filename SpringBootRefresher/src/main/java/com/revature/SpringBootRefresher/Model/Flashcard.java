package com.revature.SpringBootRefresher.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "flashcards")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(unique = true)
    private String question;
    @NotNull
    private String answer;

    @Enumerated
    private Category category;
    public enum Category {
        JAVA,SPRING,WEB,ANGULAR
    }
}
