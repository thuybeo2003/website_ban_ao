package com.rs.test.repository;

import com.rs.test.model.ChiTietAo;
import com.rs.test.model.GioHang;
import com.rs.test.model.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GHCTRepository extends JpaRepository<GioHangChiTiet , UUID> {
    GioHangChiTiet findByChiTietAoAndTrangThai(ChiTietAo chiTietAo, int trangThai);
    GioHangChiTiet findByChiTietAo(ChiTietAo chiTietAo);
    List<GioHangChiTiet> findByTrangThaiAndGioHangOrderByTgThemDesc(int trangThai, GioHang gioHang);
    GioHangChiTiet findByChiTietAoAndTrangThaiAndGioHang(ChiTietAo chiTietAo,int trangtThai,GioHang gioHang);}