package com.ioco.robot.service.impl;

import com.ioco.robot.constants.Constants;
import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.ReportsData;
import com.ioco.robot.database.repository.SurvivorsRepository;
import com.ioco.robot.service.ReportService;
import com.ioco.robot.service.RobotCpuSystemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReportServiceImpl implements ReportService {

    private SurvivorsRepository survivorsRepository;
    private RobotCpuSystemService robotCpuSystemService;

    public ReportServiceImpl(SurvivorsRepository survivorsRepository, RobotCpuSystemService robotCpuSystemService) {
        this.survivorsRepository = survivorsRepository;
        this.robotCpuSystemService = robotCpuSystemService;
    }

    @Override
    public ReportsData getReport() {
        ReportsData reportsData = null;
        try {
            reportsData = new ReportsData();
            reportsData.setMessage(Constants.SUCCESSFUL);
            Iterable<Survivor> survivors = survivorsRepository.findAll();
            double total = StreamSupport.stream(survivors.spliterator(), false).count();
            List<Survivor> infectedSurvivorsList = StreamSupport.stream(survivors.spliterator(), true).filter(survivor -> survivor.getIsInfected() == true).collect(Collectors.toList());
            List<Survivor> nonInfectedSurvivorsList = StreamSupport.stream(survivors.spliterator(), true).filter(survivor -> survivor.getIsInfected() == false).collect(Collectors.toList());
            reportsData.setPercentageOfInfectedSurvivors(calculatePercentage(infectedSurvivorsList.size(), total));
            reportsData.setPercentageOfNonInfectedSurvivors(calculatePercentage(nonInfectedSurvivorsList.size(), total));
            reportsData.setInfectedSurvivors(infectedSurvivorsList);
            reportsData.setNonInfectedSurvivors(nonInfectedSurvivorsList);
            reportsData.setRobots(robotCpuSystemService.getRobots());
        }catch (Exception e){
            reportsData = new ReportsData();
            reportsData.setMessage(Constants.FAILURE);
        }
        return reportsData;
    }

    private double calculatePercentage(int obtained, double total) {
        return obtained * Constants.HUNDRED / total;
    }
}
