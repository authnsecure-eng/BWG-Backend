package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.AdminAdministrativeWard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminAdministrativeWardRepository extends JpaRepository<AdminAdministrativeWard, Long> {
    List<AdminAdministrativeWard> findByParentIdAndStatusOrderByNameAsc(Long parentId, String status);
    List<AdminAdministrativeWard> findByStatusOrderByNameAsc(String status);
    Optional<AdminAdministrativeWard> findByNameIgnoreCaseAndStatus(String name, String status);
}
