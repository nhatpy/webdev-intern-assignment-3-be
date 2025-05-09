package com.g_scrores.g_scores.services.interfaces;

import org.springframework.stereotype.Service;

import com.g_scrores.g_scores.models.ScoreEntity;

@Service
public interface ScoreService {
    ScoreEntity getScoreBySbd(String sbd);
}
