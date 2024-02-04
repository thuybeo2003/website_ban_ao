package com.rs.test.viewModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AoViewModel {
    @Id
    @Column(name = "id_ao")
    private UUID idAo;

    @Column(name = "ten_ap")
    private String tenAo;

    @Column(name = "so_luong")
    private Long soLuong;

    @Column(name = "gia_ban")
    private double giaBan;

    @Column(name="url1")
    private String hinhAnh;

    @Column(name="ten_mau ")
    private String mauSac;
}
