package com.ioco.robot.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
public class Robot implements Serializable {
    public String model;
    public String serialNumber;
    public Date manufacturedDate;
    public String category;
}
