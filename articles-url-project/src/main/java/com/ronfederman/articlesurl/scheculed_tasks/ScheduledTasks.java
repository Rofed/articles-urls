package com.ronfederman.articlesurl.scheculed_tasks;

import com.ronfederman.articlesurl.model.Article;
import com.ronfederman.articlesurl.model.Source;
import com.ronfederman.articlesurl.model.rss.Feed;
import com.ronfederman.articlesurl.model.rss.FeedMessage;
import com.ronfederman.articlesurl.model.rss.RSSFeedParser;
import com.ronfederman.articlesurl.repositories.ArticleRepository;
import com.ronfederman.articlesurl.repositories.SourceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class ScheduledTasks {
    private final int TIME_INTERVAL = 10000;

    private final SourceRepository sourceRepository;
    private final ArticleRepository articleRepository;

    public ScheduledTasks(SourceRepository sourceRepository, ArticleRepository articleRepository) {
        this.sourceRepository = sourceRepository;
        this.articleRepository = articleRepository;
    }

    @Scheduled(fixedRate = TIME_INTERVAL)
    public void updateArticlesOfAllSources() {
        List<Source> sourceList = (List<Source>) sourceRepository.findAll();
        for (Source source : sourceList) {
            RSSFeedParser parser = new RSSFeedParser(source.getUrl());
            Feed feed = parser.readFeed();

            for (FeedMessage message : feed.getEntries()) {
                if (articleRepository.findByTitle(message.getTitle()) != null) {
                    continue;
                }
                Article article = new Article();
                article.setSource(source);
                article.setDescription(message.getDescription());
                article.setTitle(message.getTitle());
                article.setTimeStamp(LocalDateTime.now());
                article.setLink(message.getLink());
                articleRepository.save(article);
                log.info("Adding article : " + article.getTitle());
            }
            log.debug("Finished saving article to source : " + source.getUrl());
        }
    }

}
