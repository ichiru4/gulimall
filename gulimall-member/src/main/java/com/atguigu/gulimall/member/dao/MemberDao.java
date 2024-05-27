package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xuyi
 * @email yxu7633@gmail.com
 * @date 2024-05-27 10:25:47
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
