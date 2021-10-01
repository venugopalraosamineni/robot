package com.ioco.robot.service;

import com.ioco.robot.database.model.Robot;

import java.util.List;

public interface RobotCpuSystemService {
    List<Robot> getListOfRobots();
    List<Robot> getRobots();
}
