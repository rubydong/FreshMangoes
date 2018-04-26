package com.freshmangoes.app.content.repository;

import com.freshmangoes.app.content.data.Content;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContentSearch {
  @Autowired
  private EntityManager entityManager;

  public List<Content> search(String text, Integer firstResult, Integer maxResults) {
    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                                                     .buildQueryBuilder()
                                                     .forEntity(Content.class)
                                                     .get();
    Query query = queryBuilder.keyword()
                              .fuzzy()
                              .onField("metadata.name")
                              .matching(text)
                              .createQuery();
    FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Content.class)
                                                       .setFirstResult(firstResult)
                                                       .setMaxResults(maxResults);
    return fullTextQuery.getResultList();
  }
}
