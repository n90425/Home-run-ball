package com.homerunball.inq.contoller;

import com.homerunball.cart.domain.CartDto;
import com.homerunball.inq.dao.InqDao;
import com.homerunball.inq.domain.InqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
public class InqController {

    @Autowired
    InqDao inqDao;

    @GetMapping("/inqWrite")
    public String inq( HttpServletRequest request, Model m) {
        try {

            


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inqWrite";
    }
}
