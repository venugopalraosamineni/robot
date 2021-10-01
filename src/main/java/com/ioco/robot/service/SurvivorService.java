package com.ioco.robot.service;

import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.InfectedSurvivorDto;
import com.ioco.robot.dto.Response;

public interface SurvivorService {
    public Response registerSurvivor(Survivor survivor);
    public Response updateSurvivor(Survivor survivor);
    public Response updateInfectedSurvivor(InfectedSurvivorDto infectedSurvivorDto);
}
