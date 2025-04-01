package com.example.CampaignApplication.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is mandatory")
    @Column(unique = true)
    private String username;

    @NotNull(message = "Password is mandatory")
    private String password;

    @Min(value = 0, message = "Emerald balance cannot be negative")
    private double emeraldBalance;
}

