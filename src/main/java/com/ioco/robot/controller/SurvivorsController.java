package com.ioco.robot.controller;

import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.InfectedSurvivorDto;
import com.ioco.robot.dto.Response;
import com.ioco.robot.service.SurvivorService;
import com.ioco.robot.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survivor")
public class SurvivorsController {
    private SurvivorService survivorService;
    private Validator validator;

    public SurvivorsController(SurvivorService survivorService,Validator validator) {
        this.survivorService = survivorService;
        this.validator = validator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerSurvivor(@RequestBody Survivor survivor){
        List<Response> res = validator.validate(survivor);
        if(!res.isEmpty()){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(survivorService.registerSurvivor(survivor), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateSurvivor(@RequestBody Survivor survivor){
        return new ResponseEntity<>(survivorService.updateSurvivor(survivor), HttpStatus.OK);
    }

    @PutMapping("/reportSurvivorInfected")
    public ResponseEntity<?> updateInfectedSurvivor(@RequestBody InfectedSurvivorDto infectedSurvivorDto){
        return new ResponseEntity<>(survivorService.updateInfectedSurvivor(infectedSurvivorDto), HttpStatus.OK);
    }

}
