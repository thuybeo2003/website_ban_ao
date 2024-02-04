package com.rs.test.model;

import com.beust.ah.A;
import com.rs.test.model.Ao;
import com.rs.test.model.HinhAnh;
import com.rs.test.model.MauSac;
import com.rs.test.model.Size;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Chi_Tiet_Ao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChiTietAo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Chi_Tiet_Ao")
    private UUID idCTA;

    @Column(name = "ma_CTA")
    private String maCTA;

    @ManyToOne
    @JoinColumn(name = "id_Size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "id_Ao")
    @NotNull
    private Ao ao;

    @ManyToOne
    @JoinColumn(name = "id_Hinh_Anh")
    @NotNull
    private HinhAnh hinhAnh;

    @ManyToOne
    @JoinColumn(name = "id_Mau")
    @NotNull
    private MauSac mauSac;

    @Column(name = "nam_San_Xuat")
    private int namSX;

    @Column(name = "nam_Bao_Hanh")
    private int namBH;

    @Column(name = "trong_Luong")
    private int trongLuong;

    @Column(name = "gia_Ban")
    private double giaBan;

    @Column(name = "so_Luong")
    private int soLuong;

    @Column(name = "trang_Thai")
    private int trangThai;

    @Column(name = "tg_Them")
    private Date tgThem;

    @Column(name = "tg_Sua")
    private Date tgSua;

    @Column(name = "ma_NV_Sua")
    private String maNVSua;


    @Column(name = "LD_Sua")
    private String lyDoSua; 
    
    @Column(name = "barCode")
    private String barcode;

    @Column(name = "trang_thai_mail")
    private Integer trangThaiMail;

    @Column(name = "id_chi_tiet_ao_old")
    private UUID idCTGOld;

    public String getFormattedGiaBan() {
        DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
        return decimalFormat.format(giaBan);
    }
}
