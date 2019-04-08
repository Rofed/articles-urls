package com.ronfederman.articlesurl.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @URL
    private String url;
    @OneToMany
    private Set<Article> articles = new HashSet<>();

    private LocalDateTime timeStamp;
}
