package com.gear.proex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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

    @Column(name = "DataChange_CreatedTime", nullable = false)
    private Date dataChangeCreatedTime;

    @Column(name = "DataChange_LastTime")
    private Date dataChangeLastModifiedTime;

    @OneToMany(mappedBy = "footExam", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Sensor> sensors;

    @PrePersist
    protected void prePersist() {
        if (this.dataChangeCreatedTime == null) dataChangeCreatedTime = new Date();
        if (this.dataChangeLastModifiedTime == null) dataChangeLastModifiedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.dataChangeLastModifiedTime = new Date();
    }
}
