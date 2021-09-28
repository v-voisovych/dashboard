package com.rogers.dashboard.controller;


import com.rogers.dashboard.exception.LoggingException;
import com.rogers.dashboard.model.v2.TestNGResult;
import com.rogers.dashboard.service.LoggingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/autotest/logging")
@Tag(name = "Logging controller", description = "controller for getting logs from servers")
public class ElasticSearchLoggingController {

    private final LoggingService loggingService;

    @Autowired
    public ElasticSearchLoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @GetMapping("/testReport")
    @Operation(
            summary = "Method returns list of Test NG Results",
            description = "Method returns list of Test NG Results by input variable, it can be uuid, jobId, jiraID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Test NG Result",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestNGResult.class))})})
    public ResponseEntity<List<TestNGResult>> getTestCaseResult(
            @RequestParam("var") @Parameter(description = "Parameter from Test NG Result, it can be uuid, jobId, jiraID") String var,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are searching  Test NG Result",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(loggingService.getTestNGResult(hubNumber, var));
    }

    @GetMapping("/lastDayLogs")
    @Operation(
            summary = "Method returns string with logs",
            description = "Method returns string with logs for the last day from the input server")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the logs",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request, wrong index",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> lastDayLogs(
            @RequestParam("serverIndex")
            @Parameter(description = "Name index of elasticsearch",
                    examples = {
                            @ExampleObject(name = "test manager index", value = "test-manager-log"),
                            @ExampleObject(name = "selenium index", value = "selenium-log"),
                            @ExampleObject(name = "appium index", value = "appium-log"),
                            @ExampleObject(name = "ffmpeg index", value = "ffmpeg-log")}) String serverIndex,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are searching  logs",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) throws LoggingException {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(loggingService.lastDayLogs(hubNumber, serverIndex));
    }

    @GetMapping("/logsInTimeRange")
    @Operation(
            summary = "Method returns string with logs",
            description = "Method returns string with logs for some time range from the input server"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the logs",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request, wrong index or datetime",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> logsInTimeRange(
            @RequestParam("serverIndex") @Parameter(description = "Name index of elasticsearch",
                    examples = {
                            @ExampleObject(name = "test manager index", value = "test-manager-log"),
                            @ExampleObject(name = "selenium index", value = "selenium-log"),
                            @ExampleObject(name = "appium index", value = "appium-log"),
                            @ExampleObject(name = "ffmpeg index", value = "ffmpeg-log")}) String serverIndex,
            @RequestParam("timeFrom") @Parameter(description = "time for starting search logs",
                    example = "2021-09-09T09:23:40.425445") String timeFrom,
            @RequestParam("timeTo") @Parameter(description = "time for ending search logs",
                    example = "2021-09-10T19:17:40.425445") String timeTo,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are searching  logs",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) throws LoggingException {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(loggingService.logsInTimeRange(hubNumber, serverIndex, timeFrom, timeTo));
    }

    @GetMapping("/logsByTestNGResultUUID")
    @Operation(
            summary = "Method returns string with logs",
            description = "Method returns string with logs for the input Test NG Result by uuid"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the logs",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request, Test NG Result hasn't found",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> logsByUUID(
            @RequestParam("uuid") @Parameter(description = "Parameter from Test NG Result uuid") String uuid,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are searching  logs",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) throws LoggingException {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(loggingService.logsByUUID(hubNumber, uuid));
    }

    @GetMapping("/onlineLogs")
    public ResponseEntity<String> getAllLogsWithDeleting(
            @RequestParam("serverIndex") String serverIndex,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we are searching  logs",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) throws LoggingException {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(loggingService.getAllLogsWithDeleting(hubNumber, serverIndex));
    }
}
