package com.pcmc.bwg.controller;

import com.pcmc.bwg.dto.DropdownOptionDto;
import com.pcmc.bwg.service.DropdownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/v1/dropdowns", "/api/dropdowns"})
@CrossOrigin(origins = "*")
public class DropdownController {

    private final DropdownService dropdownService;

    public DropdownController(DropdownService dropdownService) {
        this.dropdownService = dropdownService;
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, List<DropdownOptionDto>>> getAllDropdowns() {
        Map<String, List<DropdownOptionDto>> dropdowns = dropdownService.getAllDropdowns();
        return ResponseEntity.ok(dropdowns);
    }

    @GetMapping("/options")
    public ResponseEntity<List<DropdownOptionDto>> getDropdownOptions(
            @RequestParam("group") String group,
            @RequestParam(value = "parentValue", required = false) String parentValue) {
        List<DropdownOptionDto> options = dropdownService.getDropdownOptions(group, parentValue);
        return ResponseEntity.ok(options);
    }

    @GetMapping("/wards")
    public ResponseEntity<List<DropdownOptionDto>> getWardsByZone(
            @RequestParam(value = "zone", required = false) String zone) {
        List<DropdownOptionDto> wards = dropdownService.getDropdownOptions("WARD", zone);
        return ResponseEntity.ok(wards);
    }
}
