package com.g_scrores.g_scores.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g_scrores.g_scores.dtos.StatisticChartDto;
import com.g_scrores.g_scores.dtos.StatisticTableDto;
import com.g_scrores.g_scores.services.interfaces.StatisticService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistic")
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/table")
    public List<StatisticTableDto> getTopGroupAStudents() {
        return statisticService.getTopGroupAStudents();
    }

    @GetMapping("/chart")
    public List<StatisticChartDto> getSubjectDistribution() {
        return statisticService.getSubjectDistribution();
    }
}
