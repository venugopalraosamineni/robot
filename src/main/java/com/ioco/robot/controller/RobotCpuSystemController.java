package com.ioco.robot.controller;

import com.ioco.robot.service.RobotCpuSystemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robots")
public class RobotCpuSystemController {
    private RobotCpuSystemService robotCpuSystemService;

    public RobotCpuSystemController(RobotCpuSystemService robotCpuSystemService) {
        this.robotCpuSystemService = robotCpuSystemService;
    }

    @GetMapping
    public ResponseEntity<?> getListOfRobots(){
        return new ResponseEntity<>(robotCpuSystemService.getListOfRobots(), HttpStatus.OK);
    }
}
