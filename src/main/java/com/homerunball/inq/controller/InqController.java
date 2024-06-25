package com.homerunball.inq.controller;

import com.homerunball.inq.dao.InqDao;
import com.homerunball.inq.domain.InqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class InqController {

    @Autowired
    InqDao inqDao;

    @PostMapping("/inqWrite") /*글 작성*/
    public String inq(String pd_id, InqDto inqDto, Model m, HttpSession session){
        try{
            int c_id = (int)session.getAttribute("c_id");
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_dt(new Date());

            System.out.println(c_id);
            System.out.println("pd_id" + pd_id );
            System.out.println(inqDto);

            int rowCnt = inqDao.insert(inqDto);
            if(rowCnt!=1)
                throw new Exception("inq write err");
//                rattr.addFlashAttribute("msg","WRT_OK");
            m.addAttribute("inqDto",inqDto);
            return "redirect:/product/detail?pd_id=" + pd_id;
        } catch (Exception e) {
            e.printStackTrace();

//            rattr.addFlashAttribute("msg","WRT_ERR");
            return "inqWrite";
        }
    }

    @GetMapping("/inqWrite")
    public String inq(Model m,HttpSession session) {
        int c_id = (int)session.getAttribute("c_id");
        System.out.println("hhhhhhhhhhhhh");
        m.addAttribute("mode", "new");
        return "inqWrite";
    }

    @GetMapping("/read")
    public String read(String pd_id, Integer inq_id, Model m, HttpSession session) {
        try {
//            int c_id = (int)session.getAttribute("c_id");

            InqDto inqDto = inqDao.select(pd_id, inq_id);

//            System.out.println("c_id" + c_id);
//            System.out.println(inq_id);
//            System.out.println(pd_id);
//            System.out.println(inqDto);

            m.addAttribute(inqDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inqWrite";
    }
}