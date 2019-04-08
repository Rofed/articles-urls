package com.ronfederman.articlesurl.controllers;


import com.ronfederman.articlesurl.model.Source;
import com.ronfederman.articlesurl.repositories.SourceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller
public class SourceController {
    SourceRepository sourceRepository;

    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }


    @PostMapping("/sources/new")
    public void newSource( @RequestBody String sourceURL){
        Source source = new Source();
        source.setUrl(sourceURL);
        source.setTimeStamp(LocalDateTime.now());
        sourceRepository.save(source);
    }
}
