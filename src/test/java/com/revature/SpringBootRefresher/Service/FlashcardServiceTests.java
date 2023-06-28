package com.revature.SpringBootRefresher.Service;

import com.revature.SpringBootRefresher.Model.Flashcard;
import com.revature.SpringBootRefresher.Repository.FlashcardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlashcardServiceTests {

    @Autowired
    FlashcardService fs;

    //Mock the flashcard repo to test the service- @MockBean is like @Mock but for @SpringBootTest
    @MockBean
    FlashcardRepository fr;

    @BeforeAll
    public void setUpTests(){
        List<Flashcard> cards = new ArrayList<>();
        Flashcard card = new Flashcard(0, "What is Spring Boot?", "Opinionated configuration extension for Spring", Flashcard.Category.SPRING);
        card = fr.save(card);
    }

    @Test
    public void createFlashcard() {
        Flashcard card = new Flashcard(0, "What is Spring Boot?", "Opinionated configuration extension for Spring", Flashcard.Category.SPRING);

        //mocking a save of card to a repo layer
        Mockito.when(fr.save(card)).thenReturn(new Flashcard(1,card.getQuestion(),card.getAnswer(),card.getCategory()));

        card = fs.createFlashcard(card);

        Assertions.assertNotEquals(0,card.getId());
        Assertions.assertEquals("What is Spring Boot?", card.getQuestion());
    }


    @Test
    public void viewAllFlashcard(){
        List<Flashcard> cards = new ArrayList<>();
        Flashcard card = new Flashcard(1, "What is Spring Boot?", "Opinionated configuration extension for Spring", Flashcard.Category.SPRING);
        cards.add(card);
        //Mocking the actions of the repo
        Mockito.when(fr.findAll()).thenReturn(cards);

        cards = fs.findAllFlashcards();

        Assertions.assertNotEquals(0, cards.size());
        Assertions.assertEquals(1, cards.get(0).getId());
    }

    }
