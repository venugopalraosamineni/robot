package com.ioco.robot.database.model;

import com.ioco.robot.enums.BoolVal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "auto_gen")
    private long id;
    private String water;
    private String food;
    private String medication;
    private String ammunition;

}
