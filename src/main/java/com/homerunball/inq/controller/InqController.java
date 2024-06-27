package com.homerunball.inq.controller;

import com.homerunball.inq.dao.InqDao;
import com.homerunball.inq.domain.InqDto;
import freemarker.ext.beans.StringModel;
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

    @GetMapping("/read")
    public String read(String pd_id, Integer inq_id, Model m, HttpSession session) {
        try {
            int c_id = (int)session.getAttribute("c_id");

            InqDto inqDto = inqDao.select(pd_id, inq_id);

            System.out.println("c_id" + c_id);
            System.out.println(inq_id);
            System.out.println(pd_id);
            System.out.println(inqDto);

            m.addAttribute(inqDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inqWrite";
    }

    public String inq(String pd_id, InqDto inqDto, Model m, HttpSession session) {
        try {
            int c_id = (int) session.getAttribute("c_id");
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_dt(new Date());

            System.out.println("c_id = " + c_id);
            System.out.println("pd_id = " + pd_id);
            System.out.println("inqDto = " + inqDto);

            int rowCnt = inqDao.insert(inqDto);
            if (rowCnt != 1)
                throw new Exception("inq write err");

            m.addAttribute("inqDto", inqDto);
            return "redirect:/product/read?pd_id="+pd_id+"&inq_id="+inqDto.getInq_id();
        } catch (Exception e) {
            e.printStackTrace();
            return "inqWrite";
        }
    }

    @GetMapping("/inqWrite")
    public String inq(String pd_id, Model m, HttpSession session) {
        Object c_id = session.getAttribute("c_id");

        System.out.println("rrrrrrrr");

        if (c_id == null) {
            return "redirect:/login";
        }
//        System.out.println("hhhhhhhhhhhhh");
        m.addAttribute("mode", "new");
        m.addAttribute("pd_id", pd_id);
        return "inqWrite";
    }


    @PostMapping("/modify") /*글 수정*/
    public String modify(String pd_id, Integer inq_id, InqDto inqDto, Model m, HttpSession session) {
        try {
            int c_id = (int) session.getAttribute("c_id");
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_dt(new Date());

//            System.out.println("inq_title=" + inq_title);
//            System.out.println("inq_content=" + inq_content);

            System.out.println("c_id =" + c_id);
            System.out.println("pd_id=" + pd_id);
            System.out.println("inqDto=" + inqDto);

            int rowCnt = inqDao.update(inqDto);
            if (rowCnt != 1)
                throw new Exception("inq MDF err");
            m.addAttribute("inqDto", inqDto);
            return "redirect:/product/read?pd_id=" + pd_id + "&inq_id=" + inq_id;
        } catch (Exception e) {
            e.printStackTrace();

            return "inqWrite";
        }
    }

    @PostMapping("/remove")
    public String remove(Integer inq_id, String pd_id, Model m, HttpSession session) {
        try {
            int c_id = (int) session.getAttribute("c_id");

//            System.out.println("c_id = " + c_id);
//            System.out.println("inq_id = " + inq_id);

            inqDao.delete(inq_id, c_id);

//            int rowCnt = inqDao.delete(inq_id, c_id);

//            if (rowCnt != 1) {
//                throw new Exception("delete err");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/product/detail?pd_id=" + pd_id;
    }
}