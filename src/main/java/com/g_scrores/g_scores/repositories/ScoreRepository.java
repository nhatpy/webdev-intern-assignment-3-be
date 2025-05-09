package com.g_scrores.g_scores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g_scrores.g_scores.models.ScoreEntity;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, String> {
    boolean existsBySbd(String sbd);

    ScoreEntity findBySbd(String sbd);
}
