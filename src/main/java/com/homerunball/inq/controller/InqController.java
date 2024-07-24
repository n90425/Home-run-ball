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
//            System.out.println(inqDto);

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
    public String inq(String pd_id, InqDto inqDto, Model m, HttpSession session, RedirectAttributes rattr, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            int c_id = (int) session.getAttribute("c_id");


//            // 파일 저장 경로 지정
//            String UPLOAD_DIR = "D:/dev/IdeaProjects/Home-run-ball/src/main/webapp/resources/uploads/";
//            String uploadPath = UPLOAD_DIR + file.getOriginalFilename();
//            File dest = new File(uploadPath);
//            file.transferTo(dest);
//            request.setAttribute("message", "파일 업로드 성공: " + uploadPath);

            String fileName = file.getOriginalFilename();
            String uploadPath = null;
            String inqfile = null;

            for (int i = 0; ; i++) {
                uploadPath = UPLOAD_DIR + c_id + "_" + i + "_" + fileName;
                inqfile = c_id + "_" + i + "_" + fileName;
                File dest = new File(uploadPath);

                // 파일이 존재하지 않으면 해당 이름 사용
                if (!dest.exists()) {
                    file.transferTo(dest);
                    request.setAttribute("message", "파일 업로드 성공: " + uploadPath);
                    System.out.println(uploadPath);
                    break;
                }
            }

            // inqDto에 파일 이름 설정
            inqDto.setInq_attch_name(inqfile);

            // 나머지 inqDto 설정
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_dt(new Date());

            int rowCnt = inqDao.insert(inqDto);

            if (rowCnt != 1)
                throw new Exception("inq write err");

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



    @PostMapping("/modify") /*글 수정*/
    public String modify(String pd_id, Integer inq_id, InqDto inqDto, Model m, HttpSession session, @RequestParam("file") MultipartFile file) {
        try {
            int c_id = (int) session.getAttribute("c_id");
            inqDto.setC_id(c_id);
            inqDto.setPd_id(pd_id);
            inqDto.setInq_attch_name(file.getOriginalFilename());
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