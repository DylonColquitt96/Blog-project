package com.survivingcodingbootcamp.blog.controller;
import static org.assertj.core.api.Assertions.assertThat;
import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.HashTagStorageJpalmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HashTagControllerTest {
    //Should Return the Hash Template
    //Should be able to connect to storage
    //Should add to Hash
    // Is this a Controller with mapping (is the controller acting how I want it to/correct annotations?)

    private HashTagController underTest;
    private Model model;
    private HashTag testHashTag;
    private HashTagStorageJpalmpl hashStorage;

    @BeforeEach
    void setUp(){
        HashTagStorage hashStorage = mock(HashTagStorage.class);
        underTest = new HashTagController(hashStorage);
        model = mock(Model.class);
        testHashTag = mock(HashTag.class);
        when(hashStorage.retrieveHashTagById(1)).thenReturn(testHashTag);
    }

    @Test
    public void displaySingleHashTagShouldReturnSingleHashTagTemplate(){
        String templateName = underTest.displaySingleHashTags(1, model);
        assertThat(templateName).isEqualTo("single-hashTag-Template");
    }

    @Test
    public void displayAllHashTagsAndReturnToHashTagTemplate(){

    }


}
