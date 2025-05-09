package com.g_scrores.g_scores.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticChartDto {
    private String subject;
    private List<Integer> studentCounts;
}
