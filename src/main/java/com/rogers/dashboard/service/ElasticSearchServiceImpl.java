package com.rogers.dashboard.service;

import com.rogers.dashboard.model.v2.TestNGResult;

import java.util.List;

public class ElasticSearchServiceImpl {

    private static volatile ElasticSearchServiceImpl ELASTICSEARCH;
    public static ElasticSearchServiceImpl getInstance() {
        if (ELASTICSEARCH == null) {
            synchronized (ElasticSearchServiceImpl.class) {
                if (ELASTICSEARCH == null) {
                    ELASTICSEARCH = new ElasticSearchServiceImpl();
                }
            }
        }
        return ELASTICSEARCH;
    }

    public List<TestNGResult> getTestNGResult(String var) {
        return null;
    }
}
