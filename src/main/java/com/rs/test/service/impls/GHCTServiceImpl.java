package com.rs.test.service.impls;

import com.rs.test.model.ChiTietAo;
import com.rs.test.model.GioHang;
import com.rs.test.model.GioHangChiTiet;
import com.rs.test.repository.GHCTRepository;
import com.rs.test.service.GHCTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GHCTServiceImpl implements GHCTService {
    @Autowired
    private GHCTRepository ghctRepository;

    @Override
    public List<GioHangChiTiet> findByGHActive(GioHang gioHang) {
        return ghctRepository.findByTrangThaiAndGioHangOrderByTgThemDesc(1,gioHang);
    }

    @Override
    public void addNeuGHCT(GioHangChiTiet gioHangChiTiet) {
        ghctRepository.save(gioHangChiTiet);
    }

    @Override
    public GioHangChiTiet findByCTSPActive(ChiTietAo chiTietAo) {
        return ghctRepository.findByChiTietAoAndTrangThai(chiTietAo,1);
    }

    @Override
    public GioHangChiTiet findByCTSP(ChiTietAo chiTietAo) {
        return ghctRepository.findByChiTietAo(chiTietAo);
    }

    @Override
    public GioHangChiTiet findByCTAActiveAndKhachHangAndTrangThai(ChiTietAo chiTietAo, GioHang gioHang) {
        return ghctRepository.findByChiTietAoAndTrangThaiAndGioHang(chiTietAo,1,gioHang);
    }

    @Override
    public void remove(GioHangChiTiet gioHangChiTiet) {
        ghctRepository.delete((gioHangChiTiet));
    }
}
