package com.ioco.robot.database.dao.impl;

import com.ioco.robot.constants.Constants;
import com.ioco.robot.database.dao.SurvivorDto;
import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.InfectedSurvivorDto;
import com.ioco.robot.dto.Response;
import com.ioco.robot.database.repository.InventoryRepository;
import com.ioco.robot.database.repository.SurvivorsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SurvivorDtoImpl implements SurvivorDto {
    Logger log = LoggerFactory.getLogger(SurvivorDtoImpl.class);
    private SurvivorsRepository survivorsRepository;
    private InventoryRepository inventoryRepository;

    public SurvivorDtoImpl(SurvivorsRepository survivorsRepository, InventoryRepository inventoryRepository) {
        this.survivorsRepository = survivorsRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public Response addSurvivor(Survivor survivor) {
        try {
            Optional<Survivor> survivors = survivorsRepository.findById(survivor.getId());
            if (!survivors.isPresent()) {
                inventoryRepository.save(survivor.getInventory());
                survivorsRepository.save(survivor);
            } else {
                return buildResponse(Constants.FIVE_HUNDRED, Constants.FAILURE, Constants.SURVIVOR_EXIST);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return buildResponse(Constants.FIVE_HUNDRED, Constants.FAILURE, e.getMessage());
        }
        return buildResponse(Constants.TWO_HUNDRED, Constants.SUCCESSFUL, Constants.SURVIVOR__REG_SUCC);
    }

    @Override
    public Response updateSurvivor(Survivor survivor) {
        try {
            Optional<Survivor> survivors = survivorsRepository.findById(survivor.getId());
            if (survivors.isPresent()) {
                inventoryRepository.save(survivor.getInventory());
                survivorsRepository.save(survivor);
            } else {
                return buildResponse(Constants.FIVE_HUNDRED, Constants.FAILURE, Constants.SURVIVOR_DOES_NOT_EXIST);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return buildResponse(Constants.FIVE_HUNDRED, Constants.FAILURE, e.getMessage());
        }
        return buildResponse(Constants.TWO_HUNDRED, Constants.SUCCESSFUL, Constants.SURVIVOR_UPDATE_SUCC);
    }

    @Override
    public Response updateInfectedSurvivor(InfectedSurvivorDto infectedSurvivorDto) {
        try {
            Optional<Survivor> survivors = survivorsRepository.findById(infectedSurvivorDto.getInfectedSurvivorId());
            if(survivors.isPresent()){
                Survivor survivor = survivors.get();
                if(survivor.getInfectionReportCount() < 3){
                    if(survivor.getInfectionReportCount() == 2) {
                        survivor.setIsInfected(true);
                    }
                    survivor.setInfectionReportCount(survivor.getInfectionReportCount() + 1);
                    survivorsRepository.save(survivor);
                    return buildResponse(Constants.TWO_HUNDRED, Constants.SUCCESSFUL, Constants.INFECTED_SURVIVOR_UPDATED);
                 } else {
                    return buildResponse(Constants.TWO_HUNDRED, Constants.SUCCESSFUL, Constants.SURVIVOR_ALREADY_INFECTED);
                }
            } else {
                return buildResponse(Constants.TWO_HUNDRED, Constants.FAILURE, Constants.SURVIVOR_DOES_NOT_EXIST);
            }
        }catch (Exception e){
            return buildResponse(Constants.FIVE_HUNDRED, Constants.FAILURE, e.getMessage());
        }
    }

    private Response buildResponse(String resCode, String resMessage, String message) {
        Response res = new Response();
        res.setResponseCode(resCode);
        res.setResponseMessage(resMessage);
        res.setMessage(message);
        return res;
    }

}
