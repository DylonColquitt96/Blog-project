package com.survivingcodingbootcamp.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class HashTag {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToMany
    private Collection <Post> posts;


    public HashTag(String name, Post...posts) {
        this.name = name;
        this.posts = List.of(posts);
    }

    public HashTag(){

    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return id == hashTag.id &&
                Objects.equals(name, hashTag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
