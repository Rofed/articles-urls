package com.ronfederman.articlesurl.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Lob
    private String description;
    @ManyToOne
    private Source source;
    private LocalDateTime timeStamp;
    private String link;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return  title.equals(article.title) &&
                description.equals(article.description) &&
                source.equals(article.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, source);
    }
}
