package com.gear.proex.model;

import com.gear.proex.enums.SensorSideEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_side", nullable = false)
    @Getter @Setter
    private SensorSideEnum sensorSide;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private  FootExam footExam;

}
