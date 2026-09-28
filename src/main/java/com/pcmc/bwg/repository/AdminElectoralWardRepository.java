package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.AdminElectoralWard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminElectoralWardRepository extends JpaRepository<AdminElectoralWard, Long> {
    List<AdminElectoralWard> findByParentIdAndStatusOrderByNameAsc(Long parentId, String status);
    List<AdminElectoralWard> findByStatusOrderByNameAsc(String status);
}
