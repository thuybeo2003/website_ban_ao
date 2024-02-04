package com.rs.test.buyerController;

import com.rs.test.model.KhachHang;
import com.rs.test.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.Date;
import java.util.Random;

@Controller
@RequestMapping("/buyer")
public class AuthController {
    private Random random = new Random();
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @GetMapping("/login")
    public String getFormBuyerLogin(){

        return "online/login";
    }
    @GetMapping("/register")
    public String getFormBuyerRegister(Model model){
        KhachHang khachHang =new KhachHang();
        model.addAttribute("formRegister",true);
        model.addAttribute("userRegister",khachHang);
        return "online/register";
    }
    @GetMapping("/logout")
    public String getFormBuyerLogout(){
        session.invalidate();
        return "redirect:/buyer/";
    }
    @PostMapping("/login")
    private String buyerLogin(Model model, HttpSession session) throws MessagingException {
        String username =request.getParameter("username");
        String password =request.getParameter("password");
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        Date date = new Date();
        Boolean b = username.matches(EMAIL_REGEX);
        if(b){
            KhachHang khachHang =khachHangService.checkLoginEmail(username,password);
            if(khachHang !=null){
                session.setAttribute("khachHangLogin",khachHang);
                return "redirect:/buyer";
            }else{
                model.addAttribute("messageLogin","Usernam and Password incorrect");
                return"online/login";
            }
        }else{
            model.addAttribute("messageLogin","Username and Password  incorrect");
            return"online/login";
        }
    }
}
