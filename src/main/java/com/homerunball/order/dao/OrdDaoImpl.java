package com.homerunball.order.dao;

import com.homerunball.order.domain.OrdDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdDaoImpl implements OrdDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.homerunball.ord.dao.OrdMapper.";

    /* 리스트 수를 센다*/
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

    /*데이터를 삭제한다*/
    @Override
    public int delete(String od_id, String c_id) throws Exception {
        Map map = new HashMap();
        map.put("od_id", od_id);
        map.put("c_id", c_id);
        return session.delete(namespace+"delete", map);
    }

    /*데이터를 모두 삭제한다*/
    @Override
    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)

    /*od_id 한개를 불러온다*/
    @Override
    public OrdDto select(String od_id, String c_id) throws Exception {

        System.out.println("asdf" + od_id);

        return session.selectOne(namespace + "select", od_id);
    } // T selectOne(String statement, Object parameter)

    /*모든 od_id를 불러온다*/
    @Override
    public List<OrdDto> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    } // Li


    @Override
    public List<OrdDto> selectOdId(String od_id) throws Exception {
        return session.selectList(namespace+"selectOdId",od_id);
    }

    /* od_id 한개를 입력해준다*/
    @Override
    public int insert(OrdDto od_id) throws Exception {
        return session.insert(namespace+"insert", od_id);
    }
//        OrdDto select(String od_id, String c_id) throws Exception; // T selectOne(String statement, Object parameter)

    /*주문 리스트를 업데이트한다*/
    @Override
    public int update(OrdDto dto) throws Exception {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)


}