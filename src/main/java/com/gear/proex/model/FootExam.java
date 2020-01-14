package com.gear.proex.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "foot_exam")
public class FootExam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    private Pacient pacient;

    @OneToMany(mappedBy = "footExam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Sensor> sensors;
}
