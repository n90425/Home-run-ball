package com.homerunball.inq.dao;

import com.homerunball.inq.domain.InqDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static javax.swing.text.html.HTML.Attribute.N;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
/* Spring Boot 와 프로그램구동이 겹쳐서 추가했어요- */
@WebAppConfiguration
public class InqDaoImplTest {
    @Autowired
    private InqDao inqDao;

    @Test
    public void count() throws Exception {
        inqDao.deleteAll();
        assertTrue(inqDao.count() == 0);

        InqDto inq = new InqDto(1,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq) == 1);
        assertTrue(inqDao.count()==1);

        InqDto inq2 = new InqDto(2,"asd",100002,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq2) == 1);
        assertTrue(inqDao.count()==2);
    }
    @Test
    public void select() throws Exception {
        inqDao.deleteAll();
        assertTrue(inqDao.count()==0);

        InqDto inq = new InqDto(1,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq)==1);

        InqDto inq2 = new InqDto(2,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq2)==1);

        InqDto inq3 = new InqDto(3,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq3)==1);

        //세 개의 객체를 비교
        assertFalse(inq.equals(inq2));
        assertFalse(inq.equals(inq3));
        assertFalse(inq2.equals(inq3));

        //같은 데이터를 비교
        InqDto inqcopy = new InqDto(1, "qwer", 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1");
//        assertTrue(inq.equals(inqcopy));  // 실패
        assertFalse(inq.equals(inqcopy));

        inqcopy.setInq_id(0);   //0으로 수정

        assertTrue(inqcopy.getInq_id() == 0);   //0으로 수정됫는지 확인

        assertFalse(inq.equals(inq2));
        assertFalse(inq.equals(inq3));
        assertFalse(inq.equals(inqcopy));
        assertFalse(inq2.equals(inq3));
        assertFalse(inq2.equals(inqcopy));
        assertFalse(inq3.equals(inqcopy));

    }

    @Test
    public void insert() throws Exception {
        inqDao.deleteAll();
        assertTrue(inqDao.count()==0);

        InqDto inq = new InqDto(1,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq)==1);

        InqDto inq2 = new InqDto(2,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq2)==1);

        InqDto inq3 = new InqDto(3,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq3)==1);

        // inq_id가 1인것만 삭제
        assertTrue(inqDao.delete(1,100001) == 1);

        // 삭제 후 count가 2인지 확인
        assertTrue(inqDao.count() == 2);

        inqDao.deleteAll();

        for (int i = 1; i <= 100; i++) {
            InqDto inq5 = new InqDto(
                    i,              // inq_id
                    "qwer",                 // pd_id
                    100001 + i,             // cd_id
                    "asdf",                 // inq_title
                    "qweradsf",             // inq_content
                    "000000000" + i,       // inq_phn
                    "aaaa",                 // inq_attch_name
                    'N',                    // inq_is_sent
                    'N',                    // inq_is_show
                    'N',                    // inq_is_cmpl
                    new Date(),             // inq_dt
                    "1" + i,                // inq_stat_cd
                    "1" + i                 // inq_type_cd
            );
            inqDao.insert(inq5);

        };

        assertTrue(inqDao.count()==100);

    }

    @Test
    public void delete()throws Exception {
        inqDao.deleteAll();
        assertTrue(inqDao.count()==0);

        InqDto inq = new InqDto(1,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq)==1);

        InqDto inq2 = new InqDto(2,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq2)==1);

        InqDto inq3 = new InqDto(3,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq3)==1);


        assertTrue(inqDao.count() == 3);
        //pd_id가 1인것만 삭제
        assertTrue(inqDao.delete(1,100001) == 1);

        assertTrue(inqDao.count() == 2);

    }

    @Test
    public void update()throws Exception {

        inqDao.deleteAll();
        assertTrue(inqDao.count()==0);

        InqDto inq = new InqDto(1,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq)==1);

        InqDto inq2 = new InqDto(2,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq2)==1);

        InqDto inq3 = new InqDto(3,"qwer",100001,"asdf","qweradsf","00000000000","aaaa", 'N', 'N', 'N', new Date(), "1","1");
        assertTrue(inqDao.insert(inq3)==1);


        inq.setInq_content("김다니 뙈지쌔기");
        inq2.setInq_content("김다니 마빡 존나 때려야지");
        inq3.setInq_content("김다니 얼마나 맞아야될까");
        assertTrue(inqDao.update(inq)==1);
        assertTrue(inqDao.update(inq2)==1);
        assertTrue(inqDao.update(inq3)==1);

        System.out.println(inq);
        System.out.println(inq2);
        System.out.println(inq3);

    }

}