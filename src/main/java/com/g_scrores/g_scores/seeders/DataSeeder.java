package com.g_scrores.g_scores.seeders;

import com.g_scrores.g_scores.models.ScoreEntity;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    private static final int BATCH_SIZE = 2000;

    @Override
    public void run(String... args) throws Exception {
        if (isDatabaseEmpty()) {
            loadDataFromCSV();
        } else {
            System.out.println("Database already seeded with data from 'diem_thi_thpt_2024.csv'");
        }
    }

    private boolean isDatabaseEmpty() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM scores", Integer.class) == 0;
    }

    private void loadDataFromCSV() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data/diem_thi_thpt_2024.csv")) {
            if (is == null) {
                throw new FileNotFoundException("Seeder file not found");
            }

            InputStreamReader reader = new InputStreamReader(is);
            CsvToBean<ScoreEntity> csvToBean = new CsvToBeanBuilder<ScoreEntity>(reader)
                    .withType(ScoreEntity.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<ScoreEntity> scoreEntities = csvToBean.parse();

            String sql = "INSERT INTO scores (sbd, toan, ngu_van, ngoai_ngu, vat_li, hoa_hoc, sinh_hoc, lich_su, dia_li, gdcd, ma_ngoai_ngu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            List<Object[]> batchArgs = new ArrayList<>();
            int count = 0;

            for (ScoreEntity scoreEntity : scoreEntities) {
                Object[] args = new Object[] {
                        scoreEntity.getSbd(),
                        scoreEntity.getToan(),
                        scoreEntity.getNgu_van(),
                        scoreEntity.getNgoai_ngu(),
                        scoreEntity.getVat_li(),
                        scoreEntity.getHoa_hoc(),
                        scoreEntity.getSinh_hoc(),
                        scoreEntity.getLich_su(),
                        scoreEntity.getDia_li(),
                        scoreEntity.getGdcd(),
                        scoreEntity.getMa_ngoai_ngu()
                };
                batchArgs.add(args);

                if (++count % BATCH_SIZE == 0) {
                    jdbcTemplate.batchUpdate(sql, batchArgs);
                    batchArgs.clear();
                }
            }

            if (!batchArgs.isEmpty()) {
                jdbcTemplate.batchUpdate(sql, batchArgs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
