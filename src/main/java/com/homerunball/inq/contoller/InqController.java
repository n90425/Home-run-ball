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

    @PostMapping("/inqWrite") /*글 작성해서 읽어오기*/
    public String inq(InqDto inqDto, Model m, HttpSession session){
        try{
            int c_id = (int)session.getAttribute("c_id");
            System.out.println(c_id);
            inqDto.setC_id(c_id);
            int rowCnt = inqDao.insert(inqDto);
            if(rowCnt!=1)
                throw new Exception("inq write err");
//                rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/prodeuct/inqWrite";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("inqDto",inqDto);
//            rattr.addFlashAttribute("msg","WRT_ERR");
            return "inqWrite";
        }
    }

    @GetMapping("/inqWrite")
    public String inq(Model m) {
        m.addAttribute("mode", "new");
        return "inqWrite";
    }

    @GetMapping("/read")
    public String read(Integer inq_id, Model m, HttpSession session) {
        try {
            int c_id = (int)session.getAttribute("c_id");
            InqDto inqDto = inqDao.select(inq_id);

            System.out.println("c_id" + c_id);
            System.out.println(inq_id);
            System.out.println(inqDto);

            m.addAttribute(inqDto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "inqWrite";
    }
}
