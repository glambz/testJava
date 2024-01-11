package com.test.testjava.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_id", nullable = false)
    private User user;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Start_at", nullable = false)
    private LocalDate startAt;

    @Column(name = "Until_at")
    private LocalDate untilAt;

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