package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.SkuImagesEntity;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
public class SkuItemVo {
    //1.sku基本信息获取 pms_sku_info
    SkuInfoEntity info;
    boolean hasStock = true;
    //2.sku的图片信息  pms_sku_images
    List<SkuImagesEntity> images;
    //3.spu的销售属性组合
    List<SkuItemSaleAttrVo> saleAttr;
    //4.spu的介绍
    SpuInfoDescEntity desp;
    //5.spu的规格参数信息
    List<SpuItemAttrGroupVo> groupAttrs;

    SeckillInfoVo seckillInfo;
    @ToString
    @Data
    public static class SkuItemSaleAttrVo {
        private Long attrId;
        private String attrName;
        private List<AttrValueWithSkuIdVo> attrValues;
    }
    @ToString
    @Data
    public static  class SpuItemAttrGroupVo{
        private String groupName;
        private List<SpuBaseAttrVo> attrs;
    }
    @ToString
    @Data
    public static class SpuBaseAttrVo {
        private String attrName;
        private List<String> attrValue;
    }
}
