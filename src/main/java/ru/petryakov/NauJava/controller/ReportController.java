package ru.petryakov.NauJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.petryakov.NauJava.entity.Report;
import ru.petryakov.NauJava.repository.ReportRepository;
import ru.petryakov.NauJava.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;
    private final ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportService reportService, ReportRepository reportRepository) {
        this.reportService = reportService;
        this.reportRepository = reportRepository;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport() {
        Long reportId = reportService.createReport();  // ← исправлено
        reportService.generateReport(reportId);
        return ResponseEntity.ok("Идёт формирование отчёта с ID: " + reportId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getReport(@PathVariable Long id) {
        Report report = reportRepository.findById(id).orElseThrow();
        return ResponseEntity.ok().body(report.getContent());
    }
}
