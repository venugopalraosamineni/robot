package com.ioco.robot.service.impl;

import com.ioco.robot.database.model.Robot;
import com.ioco.robot.service.RobotCpuSystemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RobotCpuSystemServiceImpl implements RobotCpuSystemService {

    private RestTemplate restTemplate;

    public RobotCpuSystemServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${robot.url}")
    private String url;

    @Override
    public List<Robot> getListOfRobots() {
        List<Robot> robotList = getRobots();

        Comparator<Robot> compareByCategory = Comparator
                .comparing(Robot::getCategory)
                .thenComparing(Robot::getCategory);

        List<Robot> sortedEmployees = robotList.stream()
                .sorted(compareByCategory)
                .collect(Collectors.toList());
        robotList.stream().sorted(compareByCategory);
        return sortedEmployees;
    }

    @Override
    public List<Robot> getRobots() {
        ResponseEntity<Robot[]> responseEntity =
                restTemplate.getForEntity(url, Robot[].class);
        Robot[] robots = responseEntity.getBody();
        return Arrays.asList(robots);
    }
}
