package com.g_scrores.g_scores.services.interfaces;

import org.springframework.stereotype.Service;

import com.g_scrores.g_scores.dtos.ScoreDto;

@Service
public interface ScoreService {
    ScoreDto getScoreBySbd(String sbd);
}
