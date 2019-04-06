package com.ronfederman.articlesurl.repositories;

import com.ronfederman.articlesurl.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {

    Article findByTitle(String title);
}
