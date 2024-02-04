package com.rs.test.service;

import com.rs.test.model.*;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public interface AoChiTietService {
    public List<ChiTietAo> getAllCHiTietGiay();
    public List<ChiTietAo> getTop4CHiTietAo();
    public void save(ChiTietAo chiTietGiay);
    public void update(ChiTietAo chiTietAo);
    public void deleteByIdChiTietAo(UUID id);
    public ChiTietAo getByIdChiTietAo(UUID id);
    public List<ChiTietAo> getCTAByAo(Ao ao);
    List<ChiTietAo> getCTAByAoActive(Ao ao);
    List<ChiTietAo> getCTAByAoSoldOut(Ao ao);
    HinhAnh hinhAnhByAoAndMau(Ao ao, MauSac mauSac);
    public List<ChiTietAo>fillterACT(String searchTerm);
    public List<ChiTietAo>findByAo(Ao ao);
    public List<ChiTietAo>findByMauSac(MauSac mauSac);
    public List<ChiTietAo>findBySize(Size size);
    public List<ChiTietAo>findByMauSacAndAo(Ao ao,MauSac mauSac);
    public List<ChiTietAo> findByMa(String ma);
    List<ChiTietAo> isDuplicateChiTietAo(UUID aoId, UUID sizeId, UUID mauSacId, UUID hinhAnhId);

    public void importDataFromExcel(InputStream excelFile);
}
