package com.g_scrores.g_scores.seeders;

import com.g_scrores.g_scores.models.ScoreEntity;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    private static final int BATCH_SIZE = 10000;

    @Override
    public void run(String... args) throws Exception {
        if (isDatabaseEmpty()) {
            jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0");
            jdbcTemplate.execute("ALTER TABLE scores DISABLE KEYS");
            loadDataWithMultithreading();
            jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1");
            jdbcTemplate.execute("ALTER TABLE scores ENABLE KEYS");
        } else {
            System.out.println("Database already seeded with data from 'diem_thi_thpt_2024.csv'");
        }
    }

    private boolean isDatabaseEmpty() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM scores", Integer.class) == 0;
    }

    private void loadDataWithMultithreading() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("data/diem_thi_thpt_2024.csv")) {
            List<ScoreEntity> scoreEntities = new CsvToBeanBuilder<ScoreEntity>(new InputStreamReader(is))
                    .withType(ScoreEntity.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            int processors = Runtime.getRuntime().availableProcessors();
            int chunkSize = scoreEntities.size() / processors;

            List<Thread> threads = new ArrayList<>();

            for (int i = 0; i < processors; i++) {
                final int startIdx = i * chunkSize;
                final int endIdx = (i == processors - 1) ? scoreEntities.size() : (i + 1) * chunkSize;

                Thread thread = new Thread(() -> {
                    insertBatch(scoreEntities.subList(startIdx, endIdx));
                });

                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertBatch(List<ScoreEntity> entities) {
        String sql = "INSERT INTO scores VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();

        for (ScoreEntity scoreEntity : entities) {
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

            if (batchArgs.size() >= BATCH_SIZE) {
                jdbcTemplate.batchUpdate(sql, batchArgs);
                batchArgs.clear();
            }
        }

        if (!batchArgs.isEmpty()) {
            jdbcTemplate.batchUpdate(sql, batchArgs);
        }
    }
}