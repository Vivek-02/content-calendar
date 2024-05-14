package com.learn.contentcalendar.controller;

import com.learn.contentcalendar.model.Content;
import com.learn.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Content findContentById(@PathVariable Integer id) {
        return repository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
    }
}
