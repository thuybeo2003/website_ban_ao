package com.rs.test.repository;

import com.rs.test.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AoChiTietRepository extends JpaRepository<ChiTietAo, UUID> {
    List<ChiTietAo> findByAo(Ao ao);
    List<ChiTietAo> findByTrangThaiAndAo(int trangThai,Ao ao);

    @Query(value = "SELECT DISTINCT cta.hinhAnh FROM ChiTietAo cta WHERE cta.ao = ?1 AND cta.mauSac = ?2")
    HinhAnh findDistinctByAo(Ao ao, MauSac mauSac);

    @Query("SELECT a FROM ChiTietAo a WHERE a.size.soSize = :searchTerm OR a.mauSac.tenMau = :searchTerm")
    List<ChiTietAo> customSearchCTA(@Param("searchTerm") String searchTerm);

    @Query("SELECT a FROM ChiTietAo a WHERE a.size.soSize = :searchTerm OR a.mauSac.tenMau = :searchTerm OR a.ao.tenAo = :searchTerm")
    List<ChiTietAo> customSearchACT(@Param("searchTerm") String searchTerm);
    List<ChiTietAo> findBySize(Size size);
    List<ChiTietAo> findByMauSac(MauSac mauSac);
    @Query(value = "SELECT DISTINCT cta.size FROM ChiTietAo cta WHERE cta.ao = ?1 AND cta.trangThai = 1 AND cta.mauSac = ?2 ORDER BY cta.size.soSize")
    List<Size> findDistinctSizeByAoAndTrangThai(Ao ao, MauSac mauSac);

    @Query(value = "SELECT DISTINCT cta.mauSac FROM ChiTietAo cta WHERE cta.ao = ?1 AND cta.trangThai = 1 ")
    List<MauSac> findDistinctMauSacByAoAndTrangThai(Ao ao);
    List<ChiTietAo> findByMauSacAndAoAndTrangThai(MauSac mauSac, Ao ao, int trangThai);
    List<ChiTietAo> findByAoAndMauSac(Ao ao, MauSac mauSac);
    List<ChiTietAo> findAllByOrderByTgThemDesc();
    @Query(value = "SELECT p.id_chi_tiet_ao,a.ma_ao ,a.ten_ao,h.ten_hang, p.nam_bao_hanh \n" +
            "FROM chi_tiet_ao p \n" +
            "INNER JOIN ao a on p.id_ao = a.id_ao\n" +
            "INNER JOIN hang h on a.id_hang = h.id_hang\n" +
            "WHERE p.nam_bao_hanh > 0 AND p.nam_bao_hanh < YEAR(GETDATE())", nativeQuery = true)
    List<Object[]> dsHetBaoHanh();
    @Query(value = "select sum(so_luong) from chi_tiet_ao",nativeQuery = true)
    Integer getTongAo();
    ChiTietAo findByMaCTA(String ma);

    @Query(value = "select a.so_luong,a.trang_thai_mail from chi_tiet_ao a where a.trang_thai_mail=0",nativeQuery = true)
    List<Object[]> getSoLuongTon();

    @Query("SELECT c FROM ChiTietAo c WHERE c.ao.idAo = :giayId AND c.size.idSize = :sizeId AND c.mauSac.idMau = :mauSacId AND c.hinhAnh.idHinhAnh = :hinhAnhId")
    List<ChiTietAo> findByAoAndSizeAndMauSacAndHinhAnh(
            @Param("giayId") UUID giayId,
            @Param("sizeId") UUID sizeId,
            @Param("mauSacId") UUID mauSacId,
            @Param("hinhAnhId") UUID hinhAnhId
    );
}
