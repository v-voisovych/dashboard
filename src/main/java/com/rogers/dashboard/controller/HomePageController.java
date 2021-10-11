package com.rogers.dashboard.controller;

import com.rogers.dashboard.model.home_page.HardWareInfo;
import com.rogers.dashboard.model.home_page.MQTTInfo;
import com.rogers.dashboard.model.home_page.ServerInfo;
import com.rogers.dashboard.service.HomePageService;
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

import java.util.List;

@RestController
@RequestMapping(path = "/autotest/homePage")
@Tag(name = "Home Page Controller", description = "The controller manages home page")
@CrossOrigin
public class HomePageController {

    private final HomePageService homePageService;

    @Autowired
    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping("/hardWareInfo/{hubNumber}")
    @Operation(
            summary = "Method returns list hardware info",
            description = "Method returns list hardware info from input hub"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found list hardware info",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = HardWareInfo.class))})})
    public ResponseEntity<List<HardWareInfo>> getHardWareInfo(
            @PathVariable("hubNumber")
            @Parameter(description = "Number of hub where will get hardware info",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub6")}) String hubNumber) {
        return ResponseEntity.ok().body(homePageService.getHardWareInfo(hubNumber));
    }

    @GetMapping("/serversInfo/{hubNumber}")
    @Operation(
            summary = "Method returns list server info",
            description = "Method returns list server info from input hub"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found list server info",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServerInfo.class))})})
    public ResponseEntity<List<ServerInfo>> getServerInfo(
            @PathVariable("hubNumber")
            @Parameter(description = "Number of hub where will get server info",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub6")}) String hubNumber) {
        return ResponseEntity.ok().body(homePageService.getServerInfo(hubNumber));
    }

    @GetMapping("/mqttInfo/{hubNumber}")
    @Operation(
            summary = "Method returns MQTT info",
            description = "Method returns list MQTT info from input hub"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found MQTT info",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MQTTInfo.class))})})
    public ResponseEntity<MQTTInfo> getMQTTInfo(
            @PathVariable("hubNumber")
            @Parameter(description = "Number of hub where will get MQTT info",
                    examples = {
                            @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub1"),
                            @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub2"),
                            @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub3"),
                            @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub4"),
                            @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub5"),
                            @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub6")}) String hubNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(homePageService.getMQTTInfo(hubNumber));
    }
}
