package com.homerunball.inq.dao;

import com.homerunball.inq.domain.InqDto;
import com.homerunball.order.domain.OrdDto;

import java.util.List;
import java.util.Map;

public interface InqDao {
    int count() throws Exception;
    InqDto select(String pd_id, Integer inq_id) throws Exception;

    List<InqDto> selectAll(String pd_id) throws Exception;

    int insert(InqDto inqDto) throws Exception;

    int delete(Integer inq_id, int c_id) throws Exception;

    int update(InqDto inqDto) throws Exception;

    int deleteAll() throws Exception;
}