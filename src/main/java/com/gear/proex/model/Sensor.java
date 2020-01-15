package com.gear.proex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gear.proex.enums.SensorSideEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private  String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_side", nullable = false)
    private SensorSideEnum sensorSide;

    @Column(name = "read_value")
    private Long readValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private  FootExam footExam;


}
