package com.gear.proex.model;

import com.gear.proex.enums.ProfileEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "user_name", nullable = false,unique=true)
    private String userName;

    @Column(name = "email", nullable = false,unique=true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "account_non_expired")
    public boolean accountNonExpired;

    @Column(name = "account_non_locked")
    public boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    public boolean credentialsNonExpired;

    @Column(name = "enabled")
    public boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permissions;

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        for(Permission permission: this.permissions){
            roles.add(permission.getDescription());
        }
        return roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
