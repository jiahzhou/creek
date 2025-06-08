package org.example.creek.controller;

import org.example.creek.controller.sync.SyncIpService;
import org.example.creek.model.SyncIpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/sync")
public class SyncController {

    @Resource
    private SyncIpService syncIpService;

    @PostMapping("/ip")
    public String syncIp(@RequestBody SyncIpRequest request) {
        return syncIpService.syncIp(request);
    }
}
