package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.AdminZone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminZoneRepository extends JpaRepository<AdminZone, Long> {
    List<AdminZone> findByStatusOrderByNameAsc(String status);
    Optional<AdminZone> findByNameIgnoreCaseAndStatus(String name, String status);
}
