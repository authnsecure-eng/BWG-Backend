package com.pcmc.bwg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Read-only view of the admin backend's "zones" master table. Both backends
 * share the same Postgres database, so rather than keeping a separate,
 * driftable copy of zone names in dropdown_options, the mobile app's Zone
 * dropdown queries this table live - whatever an admin has in the Zone
 * Master is exactly what a survey officer sees, with no sync step. Never
 * written to from this app: zone management stays an admin-only action.
 */
@Entity
@Table(name = "zones")
public class AdminZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
}
