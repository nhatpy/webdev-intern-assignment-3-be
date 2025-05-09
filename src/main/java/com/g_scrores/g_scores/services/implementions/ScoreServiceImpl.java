package com.g_scrores.g_scores.services.implementions;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.g_scrores.g_scores.dtos.ScoreDto;
import com.g_scrores.g_scores.exception.AppException;
import com.g_scrores.g_scores.exception.ErrorCode;
import com.g_scrores.g_scores.models.ScoreEntity;
import com.g_scrores.g_scores.repositories.ScoreRepository;
import com.g_scrores.g_scores.services.interfaces.ScoreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

    @Override
    @Cacheable(value = "score", key = "#sbd")
    public ScoreDto getScoreBySbd(String sbd) {
        if (!scoreRepository.existsBySbd(sbd)) {
            throw new AppException(ErrorCode.INVALID_INPUT);
        }
        ScoreEntity student = scoreRepository.findBySbd(sbd);

        return new ScoreDto(student);
    }

}
