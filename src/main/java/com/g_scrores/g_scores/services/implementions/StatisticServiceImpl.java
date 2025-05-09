package com.g_scrores.g_scores.services.implementions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.g_scrores.g_scores.dtos.StatisticChartDto;
import com.g_scrores.g_scores.dtos.StatisticTableDto;
import com.g_scrores.g_scores.models.ScoreEntity;
import com.g_scrores.g_scores.repositories.ScoreRepository;
import com.g_scrores.g_scores.services.interfaces.StatisticService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {
    private final ScoreRepository scoreRepository;

    @Override
    public List<StatisticTableDto> getTopGroupAStudents() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Object[]> topGroupAStudents = scoreRepository.findTopGroupAStudent(pageable);

        List<StatisticTableDto> result = new ArrayList<>();

        for (Object[] obj : topGroupAStudents) {
            ScoreEntity student = (ScoreEntity) obj[0];
            double totalScore = (double) obj[1];

            StatisticTableDto statisticTableDto = StatisticTableDto.builder()
                    .sbd(student.getSbd())
                    .toan(student.getToan())
                    .vat_li(student.getVat_li())
                    .hoa_hoc(student.getHoa_hoc())
                    .totalScore(totalScore)
                    .build();

            result.add(statisticTableDto);
        }

        return result;
    }

    @Override
    public List<StatisticChartDto> getSubjectDistribution() {

        List<Object[]> subjectDistribution = scoreRepository.getScoreDistribution();

        List<StatisticChartDto> result = subjectDistribution.stream()
                .map(row -> {
                    String subject = (String) row[0];
                    List<Integer> studentCounts = new ArrayList<>();
                    studentCounts.add(((Number) row[1]).intValue());
                    studentCounts.add(((Number) row[2]).intValue());
                    studentCounts.add(((Number) row[3]).intValue());
                    studentCounts.add(((Number) row[4]).intValue());

                    return StatisticChartDto.builder()
                            .subject(subject)
                            .studentCounts(studentCounts)
                            .build();
                })
                .toList();

        return result;
    }

}
