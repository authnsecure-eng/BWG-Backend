package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.AdminAdministrativeWard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminAdministrativeWardRepository extends JpaRepository<AdminAdministrativeWard, Long> {
    List<AdminAdministrativeWard> findByParentIdAndStatusOrderByNameAsc(Long parentId, String status);
    List<AdminAdministrativeWard> findByStatusOrderByNameAsc(String status);
}
