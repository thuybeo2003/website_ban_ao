package com.rs.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Size")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Size")
    private UUID idSize;

    @NotBlank
    @Column(name = "ma_Size")
    private String maSize;


    @Column(name = "so_Size")
    private String soSize;

    @Column(name = "trang_Thai")
    private int trangThai;

    @Column(name = "tg_Them")
    private Date tgThem;

    @Column(name = "tg_Sua")
    private Date tgSua;
}
