package com.seowoo.board.repository;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seowoo.board.entity.SearchLogEntity;
import com.seowoo.board.entity.resultSet.SearchWordResultSet;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer> {
     @Query(
          value = 
          "SELECT search_word AS searchWord, COUNT(*) AS count " +
          "FROM search_log " +
          "GROUP BY search_word " +
          "ORDER BY COUNT DESC " +
          "LIMIT 15;",
          nativeQuery=true
     )
     List<SearchWordResultSet> getTop15SearchWord();

     @Query(
          value = 
          "SELECT relation_word AS searchWord, COUNT(*) AS COUNT " + 
          "FROM search_log " +
          "WHERE search_word = ?1 " +
          "AND relation_word is NOT NULL " +
          "GROUP BY searchWord " +
          "ORDER BY COUNT DESC " +
          "LIMIT 15;",
          nativeQuery=true
     )
     List<SearchWordResultSet> getTop15RelationWord(String searchWord);
}
