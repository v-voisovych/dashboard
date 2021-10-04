package com.rogers.dashboard.controller;

import com.rogers.dashboard.service.ServerManagementService;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/autotest/serverManagement")
@Tag(name = "Server Management Controller", description = "The controller manages the start, restart and stop of servers")
public class ServerManagementController {

    private final ServerManagementService serverManagementService;

    @Autowired
    public ServerManagementController(ServerManagementService serverManagementService) {
        this.serverManagementService = serverManagementService;
    }

    @GetMapping("/startServer")
    @Operation(
            summary = "Method starts the server",
            description = "Method starts the server by input server name"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The server was started",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "408", description = "Request Timeout",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> startServer(
            @RequestParam("serverName")
            @Parameter(description = "The startup server name",
                    examples = {
                            @ExampleObject(name = "test manager server name", value = "test-manager"),
                            @ExampleObject(name = "selenium server name", value = "selenium"),
                            @ExampleObject(name = "appium server name", value = "appium"),
                            @ExampleObject(name = "ffmpeg server name", value = "ffmpeg")}) String serverName,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where server will be started",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(serverManagementService.startServer(hubNumber, serverName));
    }

    @GetMapping("/reStartServer")
    @Operation(
            summary = "Method restarts server",
            description = "Method restarts server by input server name"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server was restarted",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "408", description = "Request Timeout",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> reStartServer(
            @RequestParam("serverName")
            @Parameter(description = "The restart server name",
                    examples = {
                            @ExampleObject(name = "test manager server name", value = "test-manager"),
                            @ExampleObject(name = "selenium server name", value = "selenium"),
                            @ExampleObject(name = "appium server name", value = "appium"),
                            @ExampleObject(name = "ffmpeg server name", value = "ffmpeg")}) String serverName,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we where server will be restarted",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(serverManagementService.reStartServer(hubNumber, serverName));
    }

    @GetMapping("/stopServer")
    @Operation(
            summary = "Method stops server",
            description = "Method stops server by input server name"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server was stopped",
                    content = {@Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "408", description = "Request Timeout",
                    content = @Content(mediaType = "text/plain;charset=UTF-8",
                            schema = @Schema(implementation = String.class)))})
    public ResponseEntity<String> stopServer(
            @RequestParam("serverName")
            @Parameter(description = "The shutdown server name",
                    examples = {
                            @ExampleObject(name = "test manager server name", value = "test-manager"),
                            @ExampleObject(name = "selenium server name", value = "selenium"),
                            @ExampleObject(name = "appium server name", value = "appium"),
                            @ExampleObject(name = "ffmpeg server name", value = "ffmpeg")}) String serverName,
            @RequestParam("hubNumber") @Parameter(description = "Number of hub where we where server will be stopped",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub-1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub-2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub-3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub-4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub-5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub-6")}) String hubNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body(serverManagementService.stopServer(hubNumber, serverName));
    }
}
