package com.yadchenko.sensors.monitor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import static jakarta.persistence.EnumType.STRING;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    @Enumerated(STRING)
    private Role role;
}
