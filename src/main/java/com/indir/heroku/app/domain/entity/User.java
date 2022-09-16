package com.indir.heroku.app.domain.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    private String firstName;
    private String lastName;
    private String organisation;
    private boolean isActive = true;
}