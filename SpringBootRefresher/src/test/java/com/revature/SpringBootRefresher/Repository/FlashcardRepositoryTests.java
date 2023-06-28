package com.revature.SpringBootRefresher.Repository;

import com.revature.SpringBootRefresher.Model.Flashcard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardRepositoryTests {

    @Autowired
    public FlashcardRepository flashcardRepository;

    @BeforeAll

    void setupTestData(){
        Flashcard card = new Flashcard(0,"Test Question?","Test answer", Flashcard.Category.SPRING);
        card = flashcardRepository.save(card);
    }

    @Test
    void createFlashcard(){
        Flashcard card = new Flashcard(0,"What is Spring Boot?","Opinionated configuration extension for Spring", Flashcard.Category.SPRING);

        card = flashcardRepository.save(card);

        Assertions.assertNotEquals(0,card.getId());
    }


    @Test
    void viewAllFlashCards(){
        List<Flashcard> flashcards = flashcardRepository.findAll();

        Assertions.assertFalse(flashcards.isEmpty());
    }
}
