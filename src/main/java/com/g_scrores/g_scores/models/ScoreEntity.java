package com.g_scrores.g_scores.models;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

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
    @Column(name = "sbd")
    @CsvBindByName
    private String sbd;

    @Column(name = "toan")
    @CsvBindByName(column = "toan")
    private Double toan;

    @Column(name = "ngu_van")
    @CsvBindByName(column = "ngu_van")
    private Double ngu_van;

    @Column(name = "ngoai_ngu")
    @CsvBindByName(column = "ngoai_ngu")
    private Double ngoai_ngu;

    @Column(name = "vat_li")
    @CsvBindByName(column = "vat_li")
    private Double vat_li;

    @Column(name = "hoa_hoc")
    @CsvBindByName(column = "hoa_hoc")
    private Double hoa_hoc;

    @Column(name = "sinh_hoc")
    @CsvBindByName(column = "sinh_hoc")
    private Double sinh_hoc;

    @Column(name = "lich_su")
    @CsvBindByName(column = "lich_su")
    private Double lich_su;

    @Column(name = "dia_li")
    @CsvBindByName(column = "dia_li")
    private Double dia_li;

    @Column(name = "gdcd")
    @CsvBindByName(column = "gdcd")
    private Double gdcd;

    @Column(name = "ma_ngoai_ngu")
    @CsvBindByName(column = "ma_ngoai_ngu")
    private String ma_ngoai_ngu;
}
