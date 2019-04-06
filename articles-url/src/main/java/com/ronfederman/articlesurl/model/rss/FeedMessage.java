package com.ronfederman.articlesurl.model.rss;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FeedMessage {
    String title;
    String description;
    String link;
    String author;
    String guid;

    @Override
    public String toString() {
        return "FeedMessage{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", author='" + author + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
