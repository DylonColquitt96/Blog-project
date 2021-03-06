package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.storage.repository.HashTagRepository;
import org.springframework.stereotype.Service;

@Service
public class HashTagStorageJpalmpl implements HashTagStorage{

    private HashTagRepository hashrepo;

    public HashTagStorageJpalmpl(HashTagRepository hashrepo) {
        this.hashrepo = hashrepo;
    }

    @Override
    public Iterable<HashTag> retrieveAllHashTags() {
        return hashrepo.findAll();
    }

    @Override
    public HashTag retrieveHashTagById(long id) {
        return hashrepo.findById(id).get();
    }

    @Override
    public void save(HashTag hashTagToAdd) {
        hashrepo.save(hashTagToAdd);

    }
}
