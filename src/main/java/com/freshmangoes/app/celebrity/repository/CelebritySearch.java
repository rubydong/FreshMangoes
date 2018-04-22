package com.freshmangoes.app.celebrity.repository;

import com.freshmangoes.app.celebrity.data.Celebrity;
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
public class CelebritySearch {
  @Autowired
  private EntityManager entityManager;

  public List<Celebrity> search(String text) {
    FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
    QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                                                     .buildQueryBuilder()
                                                     .forEntity(Celebrity.class)
                                                     .get();
    Query query = queryBuilder.keyword().onField("name").matching(text).createQuery();
    FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Celebrity.class);
    return fullTextQuery.getResultList();
  }
}
