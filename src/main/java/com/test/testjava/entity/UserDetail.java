package com.test.testjava.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "User_Details")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_id", nullable = false)
    private User user;

    @Column(name = "First_name", nullable = false)
    private String firstName;

    @Column(name = "Last_name", nullable = false)
    private String lastName;

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