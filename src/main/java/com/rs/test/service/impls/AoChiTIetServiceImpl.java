package com.rs.test.service.impls;

import com.rs.test.model.*;
import com.rs.test.repository.*;
import com.rs.test.service.AoChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
public class AoChiTIetServiceImpl implements AoChiTietService {
    @Autowired
    private AoChiTietRepository aoChiTietRepository;
    @Autowired
    private AoRepository aoRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private MauSacRepository mauSacRepository;
    @Autowired
    private HinhAnhRepository hinhAnhRepository;
    @Autowired
    private HangRepository hangRepository;
    @Autowired
    private GHCTRepository ghctRepository;
    @Override
    public List<ChiTietAo> getAllCHiTietGiay() {
        return aoChiTietRepository.findAllByOrderByTgThemDesc();
    }

    @Override
    public List<ChiTietAo> getTop4CHiTietAo() {
        List<ChiTietAo> allChiTietGiay = aoChiTietRepository.findAllByOrderByTgThemDesc();
        int limit= 4;
        if(allChiTietGiay.size() <=limit){
            return allChiTietGiay;
        }else{
            return allChiTietGiay.subList(0,limit);
        }
    }

    @Override
    public void save(ChiTietAo chiTietAo) {
       aoChiTietRepository.save(chiTietAo);
    }

    @Override
    public void update(ChiTietAo chiTietAo) {
        aoChiTietRepository.save(chiTietAo);
    }

    @Override
    public void deleteByIdChiTietAo(UUID id) {
        aoChiTietRepository.deleteById(id);
    }

    @Override
    public ChiTietAo getByIdChiTietAo(UUID id) {
        return aoChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChiTietAo> getCTAByAo(Ao ao) {
        return aoChiTietRepository.findByAo(ao);
    }

    @Override
    public List<ChiTietAo> getCTAByAoActive(Ao ao) {
        return aoChiTietRepository.findByTrangThaiAndAo(1,ao);
    }

    @Override
    public List<ChiTietAo> getCTAByAoSoldOut(Ao ao) {
        return aoChiTietRepository.findByTrangThaiAndAo(2,ao);
    }

    @Override
    public HinhAnh hinhAnhByAoAndMau(Ao ao, MauSac mauSac) {
        return aoChiTietRepository.findDistinctByAo(ao,mauSac);
    }

    @Override
    public List<ChiTietAo> fillterACT(String searchTerm) {
        if("Size".equals(searchTerm) && "Màu Sắc".equals(searchTerm)){
            return aoChiTietRepository.findAll();
        }
        return aoChiTietRepository.customSearchACT(searchTerm);
    }

    @Override
    public List<ChiTietAo> findByAo(Ao ao) {
        return aoChiTietRepository.findByAo(ao);
    }

    @Override
    public List<ChiTietAo> findByMauSac(MauSac mauSac) {
        return aoChiTietRepository.findByMauSac(mauSac);
    }

    @Override
    public List<ChiTietAo> findBySize(Size size) {
        return aoChiTietRepository.findBySize(size);
    }

    @Override
    public List<ChiTietAo> findByMauSacAndAo(Ao ao, MauSac mauSac) {
        return aoChiTietRepository.findByAoAndMauSac(ao,mauSac);
    }

    @Override
    public List<ChiTietAo> findByMa(String ma) {
        return (List<ChiTietAo>) aoChiTietRepository.findByMaCTA( ma);
    }

    @Override
    public List<ChiTietAo> isDuplicateChiTietAo(UUID aoId, UUID sizeId, UUID mauSacId, UUID hinhAnhId) {
        return aoChiTietRepository.findByAoAndSizeAndMauSacAndHinhAnh(aoId, sizeId,mauSacId,hinhAnhId);
    }

    @Override
    public void importDataFromExcel(InputStream excelFile) {

    }
}
