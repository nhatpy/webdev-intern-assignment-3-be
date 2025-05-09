package com.g_scrores.g_scores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticTableDto {
    private String sbd;
    private Double toan;
    private Double vat_li;
    private Double hoa_hoc;
    private Double totalScore;
}
