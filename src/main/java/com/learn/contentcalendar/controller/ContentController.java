package com.learn.contentcalendar.controller;

import com.learn.contentcalendar.model.Content;
import com.learn.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    // find all contents in the system
    @GetMapping("")
    public List<Content> findAllContents() {
        return repository.findAll();
    }
}
