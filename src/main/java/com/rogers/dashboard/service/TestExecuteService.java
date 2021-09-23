package com.rogers.dashboard.service;

import com.rogers.dashboard.exception.TestServerException;
import com.rogers.dashboard.model.dto.ScenarioDTO;
import com.rogers.dashboard.model.v1.TestResult;
import com.rogers.dashboard.model.v2.TestNGResult;
import org.springframework.stereotype.Service;

@Service
public class TestExecuteService {

    public TestResult executeTestV1(ScenarioDTO scenarioDTO) throws TestServerException {
        return null;
    }

    public TestNGResult executeTestV2(ScenarioDTO scenarioDTO) {
        return null;
    }
}
