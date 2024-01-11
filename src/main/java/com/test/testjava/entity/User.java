package com.test.testjava.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Username", nullable = false)
    private String username;

    @Lob
    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Created_by", nullable = false)
    private Long createdBy;

    @Column(name = "Created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "Updated_by", nullable = false)
    private Long updatedBy;

    @Column(name = "Updated_at")
    private Instant updatedAt;

    @Column(name = "Deleted_by")
    private Long deletedBy;

    @Column(name = "Deleted_at")
    private Instant deletedAt;

}