package com.gear.proex.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pacient")
public class Pacient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private  Long id;

    @Column(name = "name", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "age", nullable = false)
    @Getter @Setter
    private Long age;

    @Column(name = "cpf", nullable = false,unique=true)
    @Getter @Setter
    private String cpf;

    @OneToMany(mappedBy = "pacient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<FootExam> footExams;

}
