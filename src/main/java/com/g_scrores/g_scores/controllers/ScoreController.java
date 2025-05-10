package com.g_scrores.g_scores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g_scrores.g_scores.models.ScoreEntity;
import com.g_scrores.g_scores.services.interfaces.ScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;

    @GetMapping
    public ScoreEntity getScoreBySdb(@RequestParam String sbd) {
        return scoreService.getScoreBySbd(sbd);
    }
}
