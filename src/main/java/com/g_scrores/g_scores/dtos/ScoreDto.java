package com.g_scrores.g_scores.dtos;

import com.g_scrores.g_scores.models.ScoreEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreDto {
    private ScoreEntity student;
}
