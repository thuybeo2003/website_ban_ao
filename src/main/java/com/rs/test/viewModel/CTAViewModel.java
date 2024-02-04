package com.rs.test.viewModel;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class CTAViewModel {
    @Id
    @Column(name = "id_ao")
    private UUID idAo;

    @Column(name = "id_mau")
    private UUID idMau;


    @Column(name = "min_price")
    private Double minPrice;

    @Column(name = "ten_giay")
    private String tenGiay;

    @Column(name = "ten_mau")
    private String tenMau;

    @Column(name = "slTon")
    private Long slTon;

    @Column(name = "url1")
    private String hinhAnh;

    @Column(name = "so_Luong_Da_Ban")
    private Long soLuongDaBan;

    @Column(name = "tg_NhapHang")
    private Date tgNhapHang;


    public CTAViewModel(UUID idMau,UUID idAo, Double minPrice, String tenGiay, String tenMau, Long slTon, String hinhAnh, Long soLuongDaBan, Date tgNhapHang) {
        this.idMau = idMau;
        this.idAo = idAo;
        this.minPrice = minPrice.doubleValue();
        this.tenGiay = tenGiay;
        this.tenMau = tenMau;
        this.slTon = slTon;
        this.hinhAnh = hinhAnh;
        this.soLuongDaBan = soLuongDaBan;
        this.tgNhapHang = tgNhapHang;
    }

    public CTAViewModel() {

    }
}
