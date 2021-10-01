package com.ioco.robot.database.dao;

import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.InfectedSurvivorDto;
import com.ioco.robot.dto.Response;
import org.springframework.stereotype.Component;

@Component
public interface SurvivorDto {
    public Response addSurvivor(Survivor survivor);
    public Response updateSurvivor(Survivor survivor);
    public Response updateInfectedSurvivor(InfectedSurvivorDto infectedSurvivorDto);
}
