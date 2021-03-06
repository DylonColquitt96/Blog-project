package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.repository.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;

public class HashTagStorageJpalmplTest {
//What should be tested
//1. Should be able to find post in repo
private HashTagRepository hashRepo;
private HashTagStorage underTest;
private HashTag testHashTag;

    @BeforeEach
    void setup(){
        hashRepo = mock(HashTagRepository.class);
        underTest = new HashTagStorageJpalmpl(hashRepo);
        testHashTag = mock(HashTag.class);
    }

    @Test
    public void retrieveAllHashTagsFromRepo(){
        Iterable<HashTag> hashTags = Collections.singletonList(testHashTag);
        when(hashRepo.findAll()).thenReturn(hashTags);
        assertThat(underTest.retrieveAllHashTags()).contains(testHashTag);
    }

    //2. Should be able to find specific post in repo
    @Test
    public void findHashTagByIDWithinRepo(){
        when(hashRepo.findById(1L)).thenReturn(Optional.of(testHashTag));
        HashTag retrieveHashTag = underTest.retrieveHashTagById(1);
        assertThat(retrieveHashTag).isEqualTo(testHashTag);
    }

    //3. Should be able to save post in repo
    @Test
    public void saveHashTagsWithinRepo(){
        underTest.save(testHashTag);
        verify(hashRepo).save(testHashTag);
    }
}
