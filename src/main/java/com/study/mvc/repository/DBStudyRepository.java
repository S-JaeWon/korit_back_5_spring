package com.study.mvc.repository;

import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBStudyRepository {
    public int save(Study study);
}
