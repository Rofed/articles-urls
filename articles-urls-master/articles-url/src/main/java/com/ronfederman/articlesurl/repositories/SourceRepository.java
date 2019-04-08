package com.ronfederman.articlesurl.repositories;

import com.ronfederman.articlesurl.model.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {
}
