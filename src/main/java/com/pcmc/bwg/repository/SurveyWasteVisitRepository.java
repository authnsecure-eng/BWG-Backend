package com.pcmc.bwg.repository;

import com.pcmc.bwg.entity.SurveyWasteVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface SurveyWasteVisitRepository extends JpaRepository<SurveyWasteVisit, Long> {

    List<SurveyWasteVisit> findBySurveyIdOrderByDayNumberAsc(String surveyId);

    Optional<SurveyWasteVisit> findBySurveyIdAndDayNumber(String surveyId, Integer dayNumber);
}
