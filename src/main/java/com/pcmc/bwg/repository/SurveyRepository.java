package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, String>, JpaSpecificationExecutor<Survey> {

    @Query("SELECT s FROM Survey s WHERE " +
           "(:isAdmin = true OR s.createdByUserId = :userId) AND " +
           "(:category IS NULL OR :category = '' OR LOWER(s.category) = LOWER(:category)) AND " +
           "(:status IS NULL OR :status = '' OR LOWER(s.status) = LOWER(:status)) AND " +
           "(:zone IS NULL OR :zone = '' OR :zone = 'All Zones' OR LOWER(s.zone) = LOWER(:zone)) AND " +
           "(:ward IS NULL OR :ward = '' OR :ward = 'All Wards' OR LOWER(s.ward) = LOWER(:ward)) AND " +
           "(:search IS NULL OR :search = '' OR LOWER(s.establishmentName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(s.id) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(s.ward) LIKE LOWER(CONCAT('%', :search, '%'))) " +
           "ORDER BY s.createdAt DESC")
    List<Survey> filterSurveys(
            @Param("category") String category,
            @Param("status") String status,
            @Param("zone") String zone,
            @Param("ward") String ward,
            @Param("search") String search,
            @Param("userId") Long userId,
            @Param("isAdmin") boolean isAdmin
    );

    @Query("SELECT COUNT(s) FROM Survey s WHERE " +
           "(:isAdmin = true OR s.createdByUserId = :userId) AND " +
           "(:category IS NULL OR :category = '' OR LOWER(s.category) = LOWER(:category)) AND " +
           "(:status IS NULL OR :status = '' OR LOWER(s.status) = LOWER(:status)) AND " +
           "(:zone IS NULL OR :zone = '' OR :zone = 'All Zones' OR LOWER(s.zone) = LOWER(:zone)) AND " +
           "(:ward IS NULL OR :ward = '' OR :ward = 'All Wards' OR LOWER(s.ward) = LOWER(:ward))")
    long countFiltered(
            @Param("category") String category,
            @Param("status") String status,
            @Param("zone") String zone,
            @Param("ward") String ward,
            @Param("userId") Long userId,
            @Param("isAdmin") boolean isAdmin
    );

    /** Surveys AdminBridgeClient has never successfully pushed yet - retried on a schedule. */
    List<Survey> findByAdminSyncedAtIsNull();
}
