package com.rs.test.service;

import com.rs.test.viewModel.CTAViewModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CTAViewModelService {
    List<CTAViewModel> getAll();
    Page<CTAViewModel>getAllPage(Pageable pageable);
    CTAViewModel findByAoAndMau(UUID idAo, UUID idMau);

//    List<CTAViewModel>getSoldOff();
//    List<CTAViewModel> finByIdHang(UUID idHang);
//    Page<CTAViewModel> getAllByPriceHighToLow(Pageable pageable);
//
//    Page<CTAViewModel> getAllByPriceLowToHigh(Pageable pageable);

    List<CTAViewModel> getAllOrderTgNhap();
//
    List<CTAViewModel> getAllOrderBestSeller();
}
