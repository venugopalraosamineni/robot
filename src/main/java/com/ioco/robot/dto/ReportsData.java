package com.ioco.robot.dto;

import com.ioco.robot.database.model.Robot;
import com.ioco.robot.database.model.Survivor;
import lombok.Data;

import java.util.List;

@Data
public class ReportsData {
    private String message;
    private double percentageOfInfectedSurvivors;
    private double percentageOfNonInfectedSurvivors;
    private List<Survivor> infectedSurvivors;
    private List<Survivor> nonInfectedSurvivors;
    private List<Robot> robots;
}
