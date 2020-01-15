package com.gear.proex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "foot_exam")
public class FootExam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Pacient pacient;

    @OneToMany(mappedBy = "footExam", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Sensor> sensors;
}
