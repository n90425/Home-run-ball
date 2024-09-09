package com.homerunball.inq.controller;

import com.homerunball.inq.dao.InqDao;
import com.homerunball.inq.domain.InqDto;
import freemarker.ext.beans.StringModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class InqController {

    @Autowired
    InqDao inqDao;

//    @Value("#{properties['upload.path']}")
//    private String uploadPath;

    @GetMapping("/read")
    public String read(String pd_id, Integer inq_id, Model m, HttpSession session) {
        try {
            int c_id = (int)session.getAttribute("c_id");

            InqDto inqDto = inqDao.select(pd_id, inq_id);

//            System.out.println("c_id" + c_id);
//            System.out.println(inq_id);
//            System.out.println(pd_id);
            System.out.println(inqDto);

            m.addAttribute(inqDto);
            m.addAttribute(inq_id);
            m.addAttribute(pd_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inq";
    }

    private static final String UPLOAD_DIR = "D:/dev/IdeaProjects/Home-run-ball/src/main/webapp/resources/uploads/";
    @PostMapping("/inq")
    public String inq(String pd_id, InqDto inqDto, Model m, HttpSession session,
                      RedirectAttributes rattr, @RequestParam("file") MultipartFile file) {
        try {
            int c_id = (int) session.getAttribute("c_id");
            String fileName = URLEncoder.encode(file.getOriginalFilename(), StandardCharsets.UTF_8);
            String uniqueFileName = c_id + "_" + fileName;
            String uploadPath = UPLOAD_DIR + uniqueFileName;
            File dest = new File(uploadPath);

            // 파일 저장
            file.transferTo(dest);

            // inqDto 설정
            inqDto.setInq_attch_name(uniqueFileName);
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_dt(new Date());

            int rowCnt = inqDao.insert(inqDto); // DB에 저장
            if (rowCnt != 1) throw new Exception("inq write error");

            m.addAttribute("inqDto", inqDto);
            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/product/detail?pd_id=" + pd_id;

        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "WRT_ERR");
            return "inq";
        }
    }


    @GetMapping("/inq")
    public String inq(String pd_id, InqDto inqDto, Model m, HttpSession session) {
        Object c_id = session.getAttribute("c_id");

        System.out.println("등록페이지");

        if (c_id == null) {
            return "redirect:/login";
        }

        m.addAttribute("inqDto", inqDto);
        m.addAttribute("mode", "new");
        m.addAttribute("pd_id", pd_id);
        return "inq";
    }

    /*글 수정*/
    @PostMapping("/modify")
    public String modify(String pd_id, Integer inq_id, InqDto inqDto, Model m, HttpSession session, @RequestParam("file") MultipartFile file) {
        try {
            int c_id = (int) session.getAttribute("c_id");
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_attch_name(file.getOriginalFilename());
            inqDto.setInq_dt(new Date());


//            System.out.println("inq_title=" + inq_title);
//            System.out.println("inq_content=" + inq_content);

            System.out.println("c_id111 =" + c_id);
            System.out.println("pd_id222=" + pd_id);
            System.out.println("inqDto333=" + inqDto);

            int rowCnt = inqDao.update(inqDto);
            if (rowCnt != 1)
                throw new Exception("inq MDF err");
            m.addAttribute("inqDto", inqDto);
            return "redirect:/product/read?pd_id=" + pd_id + "&inq_id=" + inq_id;
        } catch (Exception e) {
            e.printStackTrace();

            return "inq";
        }
    }

    @PostMapping("/remove")
    public String remove(Integer inq_id, String pd_id,  Model m, HttpSession session) {
        try {
            int c_id = (int) session.getAttribute("c_id");

//            inqDto.setInq_id(inq_id);

            System.out.println("c_id = " + c_id);
            System.out.println("inq_id = " + inq_id);

//            inqDao.delete(inq_id, c_id);

            int rowCnt = inqDao.delete(inq_id, c_id);

            if (rowCnt != 1) {
                throw new Exception("delete err(본인 글인지 확인");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/product/detail?pd_id=" + pd_id;
    }

}