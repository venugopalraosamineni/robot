package com.ioco.robot.validation;

import com.ioco.robot.constants.Constants;
import com.ioco.robot.database.model.Survivor;
import com.ioco.robot.dto.Response;
import com.ioco.robot.enums.BoolVal;
import com.ioco.robot.enums.Gender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {

    public List<Response> validate(Survivor survivor) {
        List<Response> res = new ArrayList<>();
        notNull(survivor.getLatitude(), "Latitude", res);
        notNull(survivor.getLongitude(), "Longitude", res);
        notNull(survivor.getName(), "Name", res);
        numValid(survivor.getAge(), "Age", res);
        numValid(survivor.getId(), "Id", res);
        enumGenderValidate(survivor.getGender(), "Gender", res);
        enumBoolValValidate(survivor.getInventory().getAmmunition(), "Ammunition", res);
        enumBoolValValidate(survivor.getInventory().getFood(), "Food", res);
        enumBoolValValidate(survivor.getInventory().getWater(), "Water", res);
        enumBoolValValidate(survivor.getInventory().getMedication(), "Medication", res);
        return res;
    }

    private void numValid(long val, String fieldName, List<Response> res) {
        Response response = new Response();
        if (val <= 0) {
            response.setMessage(Constants.FAILURE);
            response.setResponseCode("422");
            response.setResponseMessage("Please provide the valid number  ||  " + fieldName);
            res.add(response);
        }

    }

    private void notNull(String st, String fieldName, List<Response> res) {
        Response response = new Response();
        if (st == null || st.isEmpty()) {
            response.setMessage(Constants.FAILURE);
            response.setResponseCode("422");
            response.setResponseMessage("Field must not be null  ||  " + fieldName);
            res.add(response);
        }

    }

    private void enumGenderValidate(String enumVal, String fieldName, List<Response> res) {
        Response response = new Response();
        try {
            Gender.valueOf(enumVal);
        } catch (IllegalArgumentException e) {
            response.setMessage(Constants.FAILURE);
            response.setResponseCode("422");
            response.setResponseMessage("Gender should be MALE,FEMALE || " + fieldName);
            res.add(response);
        }
    }

    private void enumBoolValValidate(String enumVal, String fieldName, List<Response> res) {
        Response response = new Response();
        try {
            BoolVal.valueOf(enumVal);
        } catch (IllegalArgumentException e) {
            response.setMessage(Constants.FAILURE);
            response.setResponseCode("422");
            response.setResponseMessage("field should be Y,N  ||  " + fieldName);
            res.add(response);
        }
    }

}
