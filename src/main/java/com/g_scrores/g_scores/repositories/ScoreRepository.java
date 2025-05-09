package com.g_scrores.g_scores.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.g_scrores.g_scores.models.ScoreEntity;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, String> {
    boolean existsBySbd(String sbd);

    ScoreEntity findBySbd(String sbd);

    @Query("SELECT se, (se.toan + se.vat_li + se.hoa_hoc) AS totalScore FROM ScoreEntity se ORDER BY (se.toan + se.vat_li + se.hoa_hoc) DESC")
    List<Object[]> findTopGroupAStudent(Pageable pageable);

    @Query(value = """
            SELECT 'Toán' as subject,
                COUNT(CASE WHEN toan >= 8 THEN 1 END),
                COUNT(CASE WHEN toan >= 6 AND toan < 8 THEN 1 END),
                COUNT(CASE WHEN toan >= 4 AND toan < 6 THEN 1 END),
                COUNT(CASE WHEN toan < 4 THEN 1 END)
            FROM scores
            UNION ALL
            SELECT 'Ngữ Văn' as subject,
                COUNT(CASE WHEN ngu_van >= 8 THEN 1 END),
                COUNT(CASE WHEN ngu_van >= 6 AND ngu_van < 8 THEN 1 END),
                COUNT(CASE WHEN ngu_van >= 4 AND ngu_van < 6 THEN 1 END),
                COUNT(CASE WHEN ngu_van < 4 THEN 1 END)
            FROM scores
            UNION ALL
            SELECT CONCAT('Ngoại ngữ ', ma_ngoai_ngu) AS subject,
                COUNT(CASE WHEN ngoai_ngu >= 8 THEN 1 END),
                COUNT(CASE WHEN ngoai_ngu >= 6 AND ngoai_ngu < 8 THEN 1 END),
                COUNT(CASE WHEN ngoai_ngu >= 4 AND ngoai_ngu < 6 THEN 1 END),
                COUNT(CASE WHEN ngoai_ngu < 4 THEN 1 END)
            FROM scores
            WHERE ma_ngoai_ngu IS NOT NULL AND ngoai_ngu IS NOT NULL
            GROUP BY ma_ngoai_ngu
            UNION ALL
            SELECT 'Vật lý', COUNT(CASE WHEN vat_li >= 8 THEN 1 END),
                COUNT(CASE WHEN vat_li >= 6 AND vat_li < 8 THEN 1 END),
                COUNT(CASE WHEN vat_li >= 4 AND vat_li < 6 THEN 1 END),
                COUNT(CASE WHEN vat_li < 4 THEN 1 END) FROM scores
            UNION ALL
            SELECT 'Hóa học', COUNT(CASE WHEN hoa_hoc >= 8 THEN 1 END),
                COUNT(CASE WHEN hoa_hoc >= 6 AND hoa_hoc < 8 THEN 1 END),
                COUNT(CASE WHEN hoa_hoc >= 4 AND hoa_hoc < 6 THEN 1 END),
                COUNT(CASE WHEN hoa_hoc < 4 THEN 1 END) FROM scores
            UNION ALL
            SELECT 'Sinh học', COUNT(CASE WHEN sinh_hoc >= 8 THEN 1 END),
                COUNT(CASE WHEN sinh_hoc >= 6 AND sinh_hoc < 8 THEN 1 END),
                COUNT(CASE WHEN sinh_hoc >= 4 AND sinh_hoc < 6 THEN 1 END),
                COUNT(CASE WHEN sinh_hoc < 4 THEN 1 END) FROM scores
            UNION ALL
            SELECT 'Địa lý', COUNT(CASE WHEN dia_li >= 8 THEN 1 END),
                COUNT(CASE WHEN dia_li >= 6 AND dia_li < 8 THEN 1 END),
                COUNT(CASE WHEN dia_li >= 4 AND dia_li < 6 THEN 1 END),
                COUNT(CASE WHEN dia_li < 4 THEN 1 END) FROM scores
            UNION ALL
            SELECT 'Lịch sử', COUNT(CASE WHEN lich_su >= 8 THEN 1 END),
                COUNT(CASE WHEN lich_su >= 6 AND lich_su < 8 THEN 1 END),
                COUNT(CASE WHEN lich_su >= 4 AND lich_su < 6 THEN 1 END),
                COUNT(CASE WHEN lich_su < 4 THEN 1 END) FROM scores
            UNION ALL
            SELECT 'GDCD', COUNT(CASE WHEN gdcd >= 8 THEN 1 END),
                COUNT(CASE WHEN gdcd >= 6 AND gdcd < 8 THEN 1 END),
                COUNT(CASE WHEN gdcd >= 4 AND gdcd < 6 THEN 1 END),
                COUNT(CASE WHEN gdcd < 4 THEN 1 END) FROM scores
            """, nativeQuery = true)
    List<Object[]> getScoreDistribution();
}
