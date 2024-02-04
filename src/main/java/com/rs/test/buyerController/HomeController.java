package com.rs.test.buyerController;

import com.rs.test.model.ChiTietAo;
import com.rs.test.model.GioHang;
import com.rs.test.model.GioHangChiTiet;
import com.rs.test.model.KhachHang;
import com.rs.test.service.AoChiTietService;
import com.rs.test.service.CTAViewModelService;
import com.rs.test.service.GHCTService;
import com.rs.test.viewModel.CTAViewModel;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/buyer")
public class HomeController {
    @Autowired
    private CTAViewModelService ctaViewModelService;
    @Autowired
    private HttpSession session;
    @Autowired
    private GHCTService ghctService;
    @Autowired
    private AoChiTietService aoChiTietService;

    @RequestMapping(value = {"","/","/home"})
    public String home(Model model){
        KhachHang khachHang = (KhachHang) session.getAttribute("KhachHangLogin");
        if(khachHang != null){
            String fullName = khachHang.getHoTenKH();
            model.addAttribute("fullNameLogin",fullName);
            GioHang gioHang = (GioHang) session.getAttribute("GHLogged");
            List<GioHangChiTiet> listGHCTActive = ghctService.findByGHActive(gioHang);
            Integer sumProductInCart = listGHCTActive.size();
            model.addAttribute("sumProductInCart",sumProductInCart);
            model.addAttribute("heartLogged" , true);


        }else {
            model.addAttribute("messageLoginOrSignin", true);
        }
            List<CTAViewModel> listCTAModelNew = ctaViewModelService.getAllOrderTgNhap();
            List<CTAViewModel> listCTAModelBestSeller = ctaViewModelService.getAllOrderBestSeller();
            List<CTAViewModel> top12CTAModelNew = listCTAModelNew.subList(0,Math.min(listCTAModelNew.size(),12));
            List<CTAViewModel> top12CTAModelBetsSeller = listCTAModelBestSeller.subList(0,Math.min(listCTAModelBestSeller.size(),12));
            model.addAttribute("listCTAModelNew",top12CTAModelNew);
            model.addAttribute("listCTAModelBetsSeller",top12CTAModelBetsSeller);
            return "online/index";

        }
}
