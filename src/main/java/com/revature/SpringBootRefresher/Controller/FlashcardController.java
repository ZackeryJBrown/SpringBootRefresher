package com.revature.SpringBootRefresher.Controller;

import com.revature.SpringBootRefresher.Model.Flashcard;
import com.revature.SpringBootRefresher.Service.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flashcards")
@RequiredArgsConstructor
public class FlashcardController {

    private final FlashcardService flashcardService;

    @GetMapping("/all")
    public List<Flashcard> findAllFlashCards(){
        return flashcardService.findAllFlashcards();
    }

    @GetMapping("/{cardId}")
    public Flashcard getFlashcardById(@PathVariable int cardId){
        return flashcardService.findById(cardId);
    }

    @GetMapping
    @ResponseBody
    public Flashcard findByCategory(@RequestParam Flashcard.Category category){
        return flashcardService.findByCategory(category);
    }

    @PostMapping
    public Flashcard createFlashcard(@RequestBody Flashcard flashcard){
        return flashcardService.createFlashcard(flashcard);
    }



}
