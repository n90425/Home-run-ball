package com.homerunball.inq.dao;

import com.homerunball.inq.domain.InqDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InqDaoImpl implements InqDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.inq.dao.InqDao.";

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    }

    @Override
    public InqDto select(String pd_id) throws Exception{
        Map map = new HashMap();
        map.put("pd_id", pd_id);
        return session.selectOne(namespace + "select", map);
    }

    @Override
    public int insert(InqDto inqDto) throws Exception {
        return session.insert(namespace+"insert", inqDto);
    }

    @Override
    public int delete(int pd_id) throws Exception {
        Map map = new HashMap();
        map.put("pd_id", pd_id);
        return session.delete(namespace+"delete", map);
    }


    @Override
    public int update(int inq_id) throws Exception {
        return session.update(namespace+"update", inq_id);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace+"deleteAll");
    }

}
