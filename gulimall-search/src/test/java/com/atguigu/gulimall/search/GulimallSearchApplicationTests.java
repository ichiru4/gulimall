package com.atguigu.gulimall.search;

import lombok.Data;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@SpringBootTest
class GulimallSearchApplicationTests {
    @Autowired
    ElasticsearchRestTemplate restTemplate;
    @Autowired
    RestHighLevelClient client;


//    @Test
//    void indexData() throws IOException {
//        restTemplate.indexOps(user.class).create();
//
//        SearchRequest searchRequest = new SearchRequest("bank");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.matchQuery())
//
//        searchRequest.source(sourceBuilder);
//        SearchResponse searchResponse = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
//
//    }
    @Data
    static class user {
        private String username;
        private String password;

    }
    @Test
    void contextLoads() {
        System.out.println(client);
    }

}
