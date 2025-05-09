package com.g_scrores.g_scores.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.g_scrores.g_scores.dtos.StatisticChartDto;
import com.g_scrores.g_scores.dtos.StatisticTableDto;

@Service
public interface StatisticService {
    public List<StatisticTableDto> getTopGroupAStudents();

    public List<StatisticChartDto> getSubjectDistribution();
}
