package com.rogers.dashboard.controller;


import com.rogers.dashboard.model.home_page.SystemUsage;
import com.rogers.dashboard.service.SystemUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/autotest/systemUsage")
public class SystemUsageController {

    private final SystemUsageService systemUsageService;

    @Autowired
    public SystemUsageController(SystemUsageService systemUsageService) {
        this.systemUsageService = systemUsageService;
    }

    @GetMapping("/getSystemUsage")
    public SystemUsage getSystemUsage(@RequestParam("hubNumber") String hubNumber) {
        return systemUsageService.getSystemUsage(hubNumber);
    }
}
