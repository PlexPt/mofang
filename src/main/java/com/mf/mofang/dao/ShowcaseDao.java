package com.mf.mofang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mf.mofang.model.ShowcaseModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author pt
 */
@Mapper
@Component
public interface ShowcaseDao extends BaseMapper<ShowcaseModel> {

}
