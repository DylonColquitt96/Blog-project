package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    @Autowired
    private TopicStorage topicStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }
@GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("hashtags",postStorage.retrievePostById(id).getHashTagCollection());
        return "single-post-template";
    }

    @PostMapping("/addPost/{topicId}")
    public  String addPost(@PathVariable Long topicId, @RequestParam String newTitle, @RequestParam String newAuthor, @RequestParam String newContent){
        Post newPost = new Post(newTitle, newAuthor, topicStorage.retrieveSingleTopic(topicId), newContent);
        postStorage.save(newPost);
        return "redirect:/topics/{topicId}";
    }

}
