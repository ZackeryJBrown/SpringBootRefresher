package com.revature.SpringBootRefresher.Service;

import com.revature.SpringBootRefresher.Model.Flashcard;
import com.revature.SpringBootRefresher.Repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Required args constructor includes autowire annotation where needed
@RequiredArgsConstructor
public class FlashcardService {

    //Instantiating the associated repo into the service
    //it's autowired from the @RequiredArgsConstructor Lombok annotation on the class (final keyword required)
    private final FlashcardRepository flashcardRepository;


    public Flashcard createFlashcard(Flashcard flashcard){
        return flashcardRepository.save(flashcard);
    }

    public Flashcard findById(int id){
        // .get here solves an issue where the flash card may not exist
        return flashcardRepository.findById(id).get();
    }

    public Flashcard findByCategory(Flashcard.Category category){
        return flashcardRepository.findByCategory(category);
    }

    public List<Flashcard> findAllFlashcards(){
        return flashcardRepository.findAll();
    }
}
