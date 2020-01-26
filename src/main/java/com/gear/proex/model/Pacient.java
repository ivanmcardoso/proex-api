package com.gear.proex.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "pacient")
public class Pacient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "cpf", nullable = false,unique=true)
    private String cpf;

    @OneToMany(mappedBy = "pacient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FootExam> footExams;

}
