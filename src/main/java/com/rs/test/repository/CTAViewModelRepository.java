package com.rs.test.repository;

import com.rs.test.viewModel.CTAViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CTAViewModelRepository extends JpaRepository<CTAViewModel , UUID> {
    @Query("SELECT NEW com.rs.test.viewModel.CTAViewModel(" +
            "cta.ao.idAo, cta.mauSac.idMau, MIN(cta.giaBan), a.tenAo, cta.mauSac.tenMau, SUM(cta.soLuong), ha.url1 , COALESCE(SUM(cthd.soLuong), 0), a.namNhapHang)" +
            "FROM ChiTietAo cta " +
            "JOIN Ao a ON a.idAo = cta.ao.idAo\n" +
            "JOIN HinhAnh ha ON ha.idHinhAnh = cta.hinhAnh.idHinhAnh\n" +
            "JOIN MauSac ms ON ms.idMau = cta.mauSac.idMau\n" +
            "LEFT JOIN HoaDonChiTiet cthd ON cthd.chiTietAo.idCTA = cta.idCTA " +
            "WHERE cta.ao.idAo IS NOT NULL " +
            "AND cta.hinhAnh.idHinhAnh IS NOT NULL " +
            "AND a.trangThai = 1 " +
            "AND cta.trangThai = 1 " +
            "GROUP BY cta.ao.idAo, cta.mauSac.idMau, a.tenAo, cta.mauSac.tenMau, ha.url1, a.namNhapHang")
             List<CTAViewModel> getAll();
//    Page<CTAViewModel> getAllPage(Pageable pageable);
@Query("SELECT NEW com.rs.test.viewModel.CTAViewModel(" +
        "cta.ao.idAo, cta.mauSac.idMau, MIN(cta.giaBan), a.tenAo, cta.mauSac.tenMau, SUM(cta.soLuong), ha.url1 , COALESCE(SUM(cthd.soLuong), 0), a.namNhapHang)" +
        "FROM ChiTietAo cta " +
        "JOIN Ao a ON a.idAo = cta.ao.idAo\n" +
        "JOIN HinhAnh ha ON ha.idHinhAnh = cta.hinhAnh.idHinhAnh\n" +
        "JOIN MauSac ms ON ms.idMau = cta.mauSac.idMau\n" +
        "LEFT JOIN HoaDonChiTiet cthd ON cthd.chiTietAo.idCTA = cta.idCTA " +
        "WHERE cta.ao.idAo IS NOT NULL " +
        "AND cta.hinhAnh.idHinhAnh IS NOT NULL " +
        "AND a.trangThai = 1 " +
        "AND cta.trangThai = 1 " +
        "GROUP BY cta.ao.idAo, cta.mauSac.idMau, a.tenAo, cta.mauSac.tenMau, ha.url1, a.namNhapHang")
    Page<CTAViewModel> getAllPageable(Pageable pageable);

//    List<CTAViewModel> getAllOutOfStock();
@Query("SELECT NEW com.rs.test.viewModel.CTAViewModel(" +
        "cta.ao.idAo, cta.mauSac.idMau, MIN(cta.giaBan), a.tenAo, cta.mauSac.tenMau, SUM(cta.soLuong), ha.url1 , COALESCE(SUM(cthd.soLuong), 0), a.namNhapHang)" +
        "FROM ChiTietAo cta " +
        "JOIN Ao a ON a.idAo = cta.ao.idAo\n" +
        "JOIN HinhAnh ha ON ha.idHinhAnh = cta.hinhAnh.idHinhAnh\n" +
        "JOIN MauSac ms ON ms.idMau = cta.mauSac.idMau\n" +
        "LEFT JOIN HoaDonChiTiet cthd ON cthd.chiTietAo.idCTA = cta.idCTA " +
        "WHERE cta.ao.idAo IS NOT NULL " +
        "AND cta.hinhAnh.idHinhAnh IS NOT NULL " +
        "AND a.trangThai = 1 " +
        "AND cta.trangThai = 1 " +
        "GROUP BY cta.ao.idAo, cta.mauSac.idMau, a.tenAo, cta.mauSac.tenMau, ha.url1, a.namNhapHang")
    CTAViewModel findByAo(UUID idAo, UUID idMau);
//    Page<CTAViewModel> listCTAMHTL(Pageable pageable);
//        Page<CTAViewModel> listCTAVMHTL(Pageable pageable);
//
//    Page<CTAViewModel> listCTAVMHTH(Pageable pageable);

//    List<CTAViewModel> findByHang(UUID idHang);
@Query("SELECT NEW com.rs.test.viewModel.CTAViewModel(" +
        "cta.ao.idAo, cta.mauSac.idMau, MIN(cta.giaBan), a.tenAo, cta.mauSac.tenMau, SUM(cta.soLuong), ha.url1 , COALESCE(SUM(cthd.soLuong), 0), a.namNhapHang)" +
        "FROM ChiTietAo cta " +
        "JOIN Ao a ON a.idAo = cta.ao.idAo\n" +
        "JOIN HinhAnh ha ON ha.idHinhAnh = cta.hinhAnh.idHinhAnh\n" +
        "JOIN MauSac ms ON ms.idMau = cta.mauSac.idMau\n" +
        "LEFT JOIN HoaDonChiTiet cthd ON cthd.chiTietAo.idCTA = cta.idCTA " +
        "WHERE cta.ao.idAo IS NOT NULL " +
        "AND cta.hinhAnh.idHinhAnh IS NOT NULL " +
        "AND a.trangThai = 1 " +
        "AND cta.trangThai = 1 " +
        "GROUP BY cta.ao.idAo, cta.mauSac.idMau, a.tenAo, cta.mauSac.tenMau, ha.url1, a.namNhapHang "+
        "ORDER BY a.namNhapHang DESC")
    List<CTAViewModel> getAllOrderTgNhap();
    @Query("SELECT NEW com.rs.test.viewModel.CTAViewModel(" +
            "cta.ao.idAo, cta.mauSac.idMau, MIN(cta.giaBan), a.tenAo, cta.mauSac.tenMau, SUM(cta.soLuong), ha.url1 , COALESCE(SUM(cthd.soLuong), 0), a.namNhapHang)" +
            "FROM ChiTietAo cta " +
            "JOIN Ao a ON a.idAo = cta.ao.idAo\n" +
            "JOIN HinhAnh ha ON ha.idHinhAnh = cta.hinhAnh.idHinhAnh\n" +
            "JOIN MauSac ms ON ms.idMau = cta.mauSac.idMau\n" +
            "LEFT JOIN HoaDonChiTiet cthd ON cthd.chiTietAo.idCTA = cta.idCTA " +
            "WHERE cta.ao.idAo IS NOT NULL " +
            "AND cta.hinhAnh.idHinhAnh IS NOT NULL " +
            "AND a.trangThai = 1 " +
            "AND cta.trangThai = 1 " +
            "GROUP BY cta.ao.idAo, cta.mauSac.idMau, a.tenAo, cta. mauSac.tenMau, ha.url1, a.namNhapHang "+
            "ORDER BY coalesce(sum (cthd.soLuong),0)DESC ")
    List<CTAViewModel> getAllOrderBestSeller();

}
