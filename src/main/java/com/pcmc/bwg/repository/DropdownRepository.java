package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.DropdownOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DropdownRepository extends JpaRepository<DropdownOption, Long> {

    List<DropdownOption> findByCategoryGroupAndActiveTrueOrderBySortOrderAsc(String categoryGroup);

    List<DropdownOption> findByCategoryGroupAndParentValueAndActiveTrueOrderBySortOrderAsc(String categoryGroup, String parentValue);
}
