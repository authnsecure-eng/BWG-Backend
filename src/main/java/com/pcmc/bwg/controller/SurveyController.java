package com.pcmc.bwg.controller;

import com.pcmc.bwg.dto.*;
import com.pcmc.bwg.service.SurveyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/surveys", "/api/surveys"})
@CrossOrigin(origins = "*")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public ResponseEntity<SurveyResponseDto> createSurvey(@Valid @RequestBody SurveyCreateRequest request) {
        SurveyResponseDto response = surveyService.createSurvey(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SurveyResponseDto>> getSurveys(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "zone", required = false) String zone,
            @RequestParam(value = "ward", required = false) String ward,
            @RequestParam(value = "search", required = false) String search) {
        List<SurveyResponseDto> surveys = surveyService.getSurveys(category, status, zone, ward, search);
        return ResponseEntity.ok(surveys);
    }

    @GetMapping("/dashboard-stats")
    public ResponseEntity<DashboardStatsDto> getDashboardStats(
            @RequestParam(value = "year", required = false) String year,
            @RequestParam(value = "month", required = false) String month,
            @RequestParam(value = "zone", required = false) String zone,
            @RequestParam(value = "ward", required = false) String ward) {
        DashboardStatsDto stats = surveyService.getDashboardStats(year, month, zone, ward);
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyResponseDto> getSurveyById(@PathVariable("id") String id) {
        SurveyResponseDto survey = surveyService.getSurveyById(id);
        return ResponseEntity.ok(survey);
    }

    @PutMapping("/{id}/waste-visit")
    public ResponseEntity<SurveyResponseDto> updateWasteVisit(
            @PathVariable("id") String id,
            @Valid @RequestBody WasteVisitUpdateRequest request) {
        SurveyResponseDto updated = surveyService.updateWasteVisit(id, request);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/cpcb")
    public ResponseEntity<SurveyResponseDto> updateCpcb(
            @PathVariable("id") String id,
            @RequestBody CPCBUpdateRequest request) {
        SurveyResponseDto updated = surveyService.updateCpcb(id, request);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}/qr")
    public ResponseEntity<QRCodeResponseDto> getQrCode(@PathVariable("id") String id) {
        QRCodeResponseDto qrCode = surveyService.getQrCode(id);
        return ResponseEntity.ok(qrCode);
    }

    @GetMapping(value = "/{id}/qr/download", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> downloadQrCode(@PathVariable("id") String id) {
        byte[] pngBytes = surveyService.getQrCodePngBytes(id);
        if (pngBytes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"PCMC-QR-" + id + ".png\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE)
                .body(pngBytes);
    }
}
