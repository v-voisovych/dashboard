package com.rogers.dashboard.controller;


import com.rogers.dashboard.model.home_page.SystemUsage;
import com.rogers.dashboard.service.SystemUsageService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/autotest/systemUsage")
@CrossOrigin
public class SystemUsageController {

    private final SystemUsageService systemUsageService;

    @Autowired
    public SystemUsageController(SystemUsageService systemUsageService) {
        this.systemUsageService = systemUsageService;
    }

    @GetMapping("/getSystemUsage")
    public SystemUsage getSystemUsage(@RequestParam("hubNumber") @Parameter(description = "Number of hub where server will be started",
            examples = {
                    @ExampleObject(name = "Hub 1 (TCA 301)", value = "hub1"),
                    @ExampleObject(name = "Hub 2 (TCA 203)", value = "hub2"),
                    @ExampleObject(name = "Hub 3 (TCA 301)", value = "hub3"),
                    @ExampleObject(name = "Hub 4 (TCA 203)", value = "hub4"),
                    @ExampleObject(name = "Hub 5 (SmartHub)", value = "hub5"),
                    @ExampleObject(name = "Hub 6 (TCA 301 UA)", value = "hub6")}) String hubNumber) {
        return systemUsageService.getSystemUsage(hubNumber);
    }
}
