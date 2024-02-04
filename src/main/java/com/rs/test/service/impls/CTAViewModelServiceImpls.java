package com.rs.test.service.impls;

import com.rs.test.repository.CTAViewModelRepository;
import com.rs.test.service.CTAViewModelService;
import com.rs.test.viewModel.CTAViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CTAViewModelServiceImpls implements CTAViewModelService {
    @Autowired
    private CTAViewModelRepository ctaViewModelRepository;

    @Override
    public List<CTAViewModel> getAll() {
        return ctaViewModelRepository.getAll();
    }

    @Override
    public Page<CTAViewModel> getAllPage(Pageable pageable) {
        return ctaViewModelRepository.getAllPageable(pageable);
    }

    @Override
    public CTAViewModel findByAoAndMau(UUID idAo, UUID idMau) {
        return ctaViewModelRepository.findByAo(idAo,idMau);
    }

    @Override
    public List<CTAViewModel> getAllOrderTgNhap() {
        return ctaViewModelRepository.getAllOrderTgNhap();
    }

//    @Override
//    public List<CTAViewModel> getSoldOff() {
//        return ctaViewModelRepository.getAllOutOfStock();
//    }

//    @Override
//    public List<CTAViewModel> finByIdHang(UUID idHang) {
//        return ctaViewModelRepository.findByHang(idHang);
//    }

//    @Override
//    public Page<CTAViewModel> getAllByPriceHighToLow(Pageable pageable) {
//        return ctaViewModelRepository.listCTAVMHTL(pageable);
//    }
//
//    @Override
//    public Page<CTAViewModel> getAllByPriceLowToHigh(Pageable pageable) {
//        return ctaViewModelRepository.listCTAVMHTH(pageable);
//    }


    @Override
    public List<CTAViewModel> getAllOrderBestSeller() {
        return ctaViewModelRepository.getAllOrderBestSeller();
    }
}
