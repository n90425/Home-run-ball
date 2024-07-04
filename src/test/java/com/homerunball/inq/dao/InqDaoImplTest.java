package com.homerunball.inq.dao;

import com.homerunball.inq.domain.InqDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class InqDaoImplTest {
    @Autowired
    private InqDao inqDao;

    @Test
    public void count() throws Exception {
        inqDao.deleteAll();
        String pd_id1 = "100001";
        String pd_id2 = "100002";

        assertTrue(inqDao.count(pd_id1) == 0);

        InqDto inq1 = new InqDto(1, pd_id1, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq1) == 1);
        assertTrue(inqDao.count(pd_id1) == 1);

        InqDto inq2 = new InqDto(2, pd_id2, 100002, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq2) == 1);
        assertTrue(inqDao.count(pd_id1) == 1);  // pd_id1에 대한 카운트는 여전히 1
        assertTrue(inqDao.count(pd_id2) == 1);  // pd_id2에 대한 카운트는 1
    }

    @Test
    public void select() throws Exception {
        inqDao.deleteAll();
        String pd_id = "100001";
        assertTrue(inqDao.count(pd_id) == 0);

        InqDto inq1 = new InqDto(1, pd_id, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq1) == 1);

        InqDto inq2 = new InqDto(2, pd_id, 100002, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq2) == 1);

        InqDto inq3 = new InqDto(3, pd_id, 100003, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq3) == 1);

        // 세 개의 객체를 비교
        assertFalse(inq1.equals(inq2));
        assertFalse(inq1.equals(inq3));
        assertFalse(inq2.equals(inq3));

        // 같은 데이터를 비교
        InqDto inqCopy = new InqDto(1, pd_id, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertFalse(inq1.equals(inqCopy));

        inqCopy.setInq_id(0); // ID를 0으로 수정
        assertTrue(inqCopy.getInq_id() == 0); // ID가 0으로 수정되었는지 확인

        assertFalse(inq1.equals(inq2));
        assertFalse(inq1.equals(inq3));
        assertFalse(inq1.equals(inqCopy));
        assertFalse(inq2.equals(inq3));
        assertFalse(inq2.equals(inqCopy));
        assertFalse(inq3.equals(inqCopy));
    }

    @Test
    public void insert() throws Exception {
        inqDao.deleteAll();
        String pd_id = "100001";
        assertTrue(inqDao.count(pd_id) == 0);

        InqDto inq1 = new InqDto(1, pd_id, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq1) == 1);

        InqDto inq2 = new InqDto(2, pd_id, 100002, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq2) == 1);

        InqDto inq3 = new InqDto(3, pd_id, 100003, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq3) == 1);

        // inq_id가 1인 것만 삭제
        assertTrue(inqDao.delete(1, 100001) == 1);

        // 삭제 후 count가 2인지 확인
        assertTrue(inqDao.count(pd_id) == 2);

        inqDao.deleteAll();

        for (int i = 1; i <= 100; i++) {
            InqDto inq = new InqDto(
                    i,              // inq_id
                    pd_id,                 // pd_id
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
                    "1" + i,                 // inq_type_cd
                    "asdf"                  // c_name
            );
            inqDao.insert(inq);
        }

        assertTrue(inqDao.count(pd_id) == 100);
    }

    @Test
    public void delete() throws Exception {
        inqDao.deleteAll();
        String pd_id = "100001";
        assertTrue(inqDao.count(pd_id) == 0);

        InqDto inq1 = new InqDto(1, pd_id, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq1) == 1);

        InqDto inq2 = new InqDto(2, pd_id, 100002, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adsf");
        assertTrue(inqDao.insert(inq2) == 1);

        InqDto inq3 = new InqDto(3, pd_id, 100003, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq3) == 1);

        assertTrue(inqDao.count(pd_id) == 3);

        // inq_id가 1인 것만 삭제
        assertTrue(inqDao.delete(1, 100001) == 1);

        assertTrue(inqDao.count(pd_id) == 2);
    }

    @Test
    public void update() throws Exception {
        inqDao.deleteAll();
        String pd_id = "100001";
        assertTrue(inqDao.count(pd_id) == 0);

        InqDto inq1 = new InqDto(1, pd_id, 100001, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "asdf");
        assertTrue(inqDao.insert(inq1) == 1);

        InqDto inq2 = new InqDto(2, pd_id, 100002, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq2) == 1);

        InqDto inq3 = new InqDto(3, pd_id, 100003, "asdf", "qweradsf", "00000000000", "aaaa", 'N', 'N', 'N', new Date(), "1", "1", "adf");
        assertTrue(inqDao.insert(inq3) == 1);

        // inq1, inq2, inq3 업데이트
        inq1.setInq_content("김다니 뙈지쌔기");
        inq2.setInq_content("김다니 마빡 존나 때려야지");
        inq3.setInq_content("김다니 얼마나 맞아야될까");
        assertTrue(inqDao.update(inq1) == 1);
        assertTrue(inqDao.update(inq2) == 1);
        assertTrue(inqDao.update(inq3) == 1);

        System.out.println(inq1);
        System.out.println(inq2);
        System.out.println(inq3);
    }
}