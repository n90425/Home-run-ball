package com.homerunball.inq.dao;

import com.homerunball.inq.domain.InqDto;

import java.util.Map;

public interface InqDao {
    int count() throws Exception;
    InqDto select(String pd_id) throws Exception;

    int insert(InqDto inqDto) throws Exception;

    int delete(int pd_id) throws Exception;

    int update(int inq_id) throws Exception;

    int deleteAll() throws Exception;
}