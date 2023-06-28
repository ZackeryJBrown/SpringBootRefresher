package com.revature.SpringBootRefresher.Repository;

import com.revature.SpringBootRefresher.Model.Flashcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard,Integer> {

    //TODO find by category
    public Flashcard findByCategory(Flashcard.Category category);
}
