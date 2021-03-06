package com.survivingcodingbootcamp.blog.controller;



import com.survivingcodingbootcamp.blog.model.HashTag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.HashTagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorageJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashTagController {

    private HashTagStorage hashStorage;
    @Autowired
    private PostStorage storePost;




    public HashTagController(HashTagStorage hashStorage) {
        this.hashStorage = hashStorage;
    }

    @GetMapping("/{id}")
    public String displaySingleHashTags(@PathVariable long id, Model model) {
        model.addAttribute("hashtags", hashStorage.retrieveHashTagById(id));
        return "single-hashTag-Template";
    }

    @GetMapping
    public String displayAllHashtags(Model model) {
        model.addAttribute("allHashtags", hashStorage.retrieveAllHashTags());
        return "hashTag-template";
    }

    @PostMapping("/{postId}")
    public String addHashtags(@PathVariable Long postId, @RequestParam String newHashTag){
        HashTag addNewHashTag = new HashTag(newHashTag, storePost.retrievePostById(postId));
        hashStorage.save(addNewHashTag);
        return "redirect:/posts/{postId}";
    }
}
