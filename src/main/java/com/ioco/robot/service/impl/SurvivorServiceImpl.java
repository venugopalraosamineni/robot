package com.ioco.robot.service.impl;

import com.ioco.robot.database.dao.SurvivorDto;
import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.InfectedSurvivorDto;
import com.ioco.robot.dto.Response;
import com.ioco.robot.service.SurvivorService;
import org.springframework.stereotype.Service;

@Service
public class SurvivorServiceImpl implements SurvivorService {
    private SurvivorDto survivorDto;

    public SurvivorServiceImpl(SurvivorDto survivorDto) {
        this.survivorDto = survivorDto;
    }

    @Override
    public Response registerSurvivor(Survivor survivor) {
        return survivorDto.addSurvivor(survivor);
    }

    @Override
    public Response updateSurvivor(Survivor survivor) {
        return survivorDto.updateSurvivor(survivor);
    }

    @Override
    public Response updateInfectedSurvivor(InfectedSurvivorDto infectedSurvivorDto) {
        return survivorDto.updateInfectedSurvivor(infectedSurvivorDto);
    }
}
