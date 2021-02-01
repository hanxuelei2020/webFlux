package com.hasut.webflux.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hasut.webflux.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
