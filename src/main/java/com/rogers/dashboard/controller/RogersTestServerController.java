package com.rogers.dashboard.controller;

import com.rogers.dashboard.exception.TestServerException;
import com.rogers.dashboard.model.dto.ScenarioDTO;
import com.rogers.dashboard.model.v1.TestResult;
import com.rogers.dashboard.model.v2.TestNGResult;
import com.rogers.dashboard.service.TestExecuteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/autotest")
@Tag(name = "Rogers test server controller", description = "controller for running test cases")
public class RogersTestServerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RogersTestServerController.class);

    private final TestExecuteService testExecuteService;

    public RogersTestServerController(TestExecuteService testExecuteService) {
        this.testExecuteService = testExecuteService;
    }

    @PostMapping(path = "/runTest")
    @Operation(
            summary = "Method execute test case version 1",
            description = "Method execute test case version 1 by ScenarioDTO"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Test case v1 finished",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestResult.class))})})
    public ResponseEntity runTestForJiraIdV1(
            @Valid @RequestBody() @Parameter(description = "Schema for executing test") ScenarioDTO scenarioDTO,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are executing test case v1",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        LOGGER.info("POST: /autotest/runTest \n{}", scenarioDTO);
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .header("Content-Type", "application/json")
                    .body(testExecuteService.executeTestV1(hubNumber, scenarioDTO));
        } catch (TestServerException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping(path = "/v2/runTest")
    @Operation(
            summary = "Method execute test case version 2",
            description = "Method execute test case version 2 by ScenarioDTO"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Test case v2 finished",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestNGResult.class))})})
    public ResponseEntity runTestForJiraIdV2(
            @Valid @RequestBody() @Parameter(description = "Schema for executing test") ScenarioDTO scenarioDTO,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are executing test case v2",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        LOGGER.info("POST: /autotest/runTest \n{}", scenarioDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(testExecuteService.executeTestV2(hubNumber, scenarioDTO));
    }

//    @Hidden
//    @Deprecated
//    @PostMapping(path = "/validate")
//    public ResponseEntity runTestForDeviceProperty(@Valid @RequestBody() com.rogers.xhome.autotest.testmanager.v1.model.ScenarioDTO scenarioDTO) {
//        LOGGER.info("POST: /autotest/validate \n{}", scenarioDTO);
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(autoTestService.testDevice(scenarioDTO));
//        } catch (TestServerException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    @Hidden
//    @Deprecated
//    @PostMapping(path = "/runTestQueue")
//    public ResponseEntity runTestQueueForDeviceProperty(@Valid @RequestBody() TestQueue testQueue) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(autoTestService.submitTestQueue(testQueue));
//        } catch (TestServerException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
//    @Hidden
//    @Deprecated
//    @PostMapping(path = "/getTestQueueResult")
//    public ResponseEntity getTestQueueResult(@Valid @RequestBody() TestQueue testQueue) {
//        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(autoTestService.getTestQueueResult(testQueue));
//    }
//
//    @Hidden
//    @PostMapping(path = "/endSession")
//    public ResponseEntity endSession() {
//        PreTestValidationResultContext.getInstance().setPreTestValidation(new HashMap<>());
//        return ResponseEntity.status(HttpStatus.OK).body(autoTestService.endSession());
//    }
//
//    @Hidden
//    @GetMapping(path = "/result/{callId}")
//    public ResponseEntity checkResults(@PathVariable("callId") String callId) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .header("Content-Type", "application/json")
//                .body(autoTestService.getTestResultAsJson(callId));
//    }
//
//    @Hidden
//    @GetMapping(path = "/health")
//    public ResponseEntity health() {
//        return ResponseEntity.status(HttpStatus.OK)
//                .header("Content-Type", "application/json")
//                .body(healthService.getTestServerHealth());
//    }


//    @Autowired
//    public void setAutoTestService(AutoTestService autoTestService) {
//        this.autoTestService = autoTestService;
//    }
//
//    @Autowired
//    public void setHealthService(HealthService healthService) {
//        this.healthService = healthService;
//    }
}
