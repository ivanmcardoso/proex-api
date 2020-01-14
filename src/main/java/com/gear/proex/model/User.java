package com.gear.proex.model;

import com.gear.proex.enums.ProfileEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Column(name = "name", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "user_name", nullable = false,unique=true)
    @Getter @Setter
    private String userName;

    @Column(name = "email", nullable = false,unique=true)
    @Getter @Setter
    private String email;

    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false)
    @Getter @Setter
    private ProfileEnum profile;
}
