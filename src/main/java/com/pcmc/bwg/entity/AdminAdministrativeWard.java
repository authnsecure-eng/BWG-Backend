package com.pcmc.bwg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Read-only view of the admin backend's "administrative_wards" master
 * table - see AdminZone for why this app reads it live instead of keeping
 * its own copy. parent_id is the owning zone's id (zones.id).
 */
@Entity
@Table(name = "administrative_wards")
public class AdminAdministrativeWard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public Long getId() { return id; }
    public Long getParentId() { return parentId; }
    public String getName() { return name; }
    public String getStatus() { return status; }
}
