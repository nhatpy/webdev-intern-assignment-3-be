package com.g_scrores.g_scores.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scores")
@Entity
public class ScoreEntity implements Serializable {
    @Id
    @Column(name = "id")
    private String sbd;

    @Column(name = "toan")
    private Double toan;

    @Column(name = "ngu_van")
    private Double nguVan;

    @Column(name = "ngoai_ngu")
    private Double ngoaiNgu;

    @Column(name = "vat_li")
    private Double vatLi;

    @Column(name = "hoa_hoc")
    private Double hoaHoc;

    @Column(name = "sinh_hoc")
    private Double sinhHoc;

    @Column(name = "lich_su")
    private Double lichSu;

    @Column(name = "dia_ly")
    private Double diaLy;

    @Column(name = "gdcd")
    private Double gdcd;

    @Column(name = "ma_ngoai_ngu")
    private String maNgoaiNgu;
}
