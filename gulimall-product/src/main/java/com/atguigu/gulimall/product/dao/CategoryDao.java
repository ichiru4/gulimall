package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuyi
 * @email yxu7633@gmail.com
 * @date 2024-05-22 17:14:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
