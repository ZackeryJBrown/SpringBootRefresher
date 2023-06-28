package com.revature.SpringBootRefresher.Controller;

import com.revature.SpringBootRefresher.Service.FlashcardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureMockMvc required for Controller layer tests
@AutoConfigureMockMvc
public class FlashcardControllerTests {

    //MockBean the service layer for testing
    @MockBean
    FlashcardService flashcardService;

    //Autowire an mvc
    @Autowired
    MockMvc mvc;

    @Test
    public void getCardById() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/flashcards/1"));
        resultActions.andExpect(status().isOk());

    }


    @Test
    public void checkValueFromBetByIdRequest(){

    }


}
