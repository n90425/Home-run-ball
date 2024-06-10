package com.homerunball.inq.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    }
//    @Test
//    public void select() throws Exception {
//    }
//
//    @Test
//    public void insert() {
//    }
//
//    @Test
//    public void delete() {
//    }
//
//    @Test
//    public void update() {
//    }
//
//    @Test
//    public void deleteAll() {
//    }
}