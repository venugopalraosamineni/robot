package com.ioco.robot.database.model;

import com.ioco.robot.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class Survivor {
    @Id
    @Column(nullable = false)
    private long id;
    private String name;
    private int age;
    private String gender;
    private String latitude;
    private String longitude;
    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;
    private Boolean isInfected;
    private int InfectionReportCount = 0;
}
