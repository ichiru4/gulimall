package com.atguigu.gulimall.search.vo;

import lombok.Data;

import java.util.List;

/**
 * 封装页面所有可能传递过来的查询条件
 */
@Data
public class SearchParam {
    private String keyword;//全文匹配关键字
    private Long catalog3Id;//三级分类
    /**
     *  sort =saleCount_asc/dsc
     *  sort =skuPrice_asc/dsc
     *  sort =hotScore_asc/dsc
     */


    private String sort;//排序条件
    /**
     * 过滤条件
     * hasStock(是否有货)，skuPrice区间、brandID、catalog3Id、attrs
     * skuPrice=1_500/_500/500_
     */
    private Integer hasStock ;//是否有货
    private String skuPrice;//价格区间
    private List<Long> brandId;//按照品牌进行查询
    private List<String> attrs;
    private Integer pageNum = 1;
    private String _queryString;



    // Id
}
