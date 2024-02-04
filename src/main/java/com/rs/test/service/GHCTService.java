package com.rs.test.service;

import com.rs.test.model.ChiTietAo;
import com.rs.test.model.GioHang;
import com.rs.test.model.GioHangChiTiet;

import java.util.List;

public interface GHCTService {
    List<GioHangChiTiet> findByGHActive(GioHang gioHang);
    void addNeuGHCT(GioHangChiTiet gioHangChiTiet);
    GioHangChiTiet findByCTSPActive(ChiTietAo chiTietAo);
    GioHangChiTiet findByCTSP(ChiTietAo chiTietAo);
    GioHangChiTiet findByCTAActiveAndKhachHangAndTrangThai(ChiTietAo chiTietAo,GioHang gioHang);
    void remove(GioHangChiTiet gioHangChiTiet);
}
