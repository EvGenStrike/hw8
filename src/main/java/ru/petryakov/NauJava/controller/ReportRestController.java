package ru.petryakov.NauJava.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.petryakov.NauJava.entity.Report;
import ru.petryakov.NauJava.entity.ReportStatus;
import ru.petryakov.NauJava.service.ReportService;
import ru.petryakov.NauJava.repository.ReportRepository;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportRestController {

    private final ReportService reportService;
    private final ReportRepository reportRepository;

    @PostMapping
    public Long createReport() {
        Long reportId = reportService.createReport();
        reportService.generateReportAsync(reportId);
        return reportId;
    }


    @GetMapping("/{id}")
    public String getReport(@PathVariable Long id) {
        return reportRepository.findById(id)
                .map(report -> {
                    ReportStatus status = report.getStatus();
                    return switch (status) {
                        case CREATED -> "Отчет еще формируется...";
                        case ERROR -> "Произошла ошибка при формировании отчета.";
                        case COMPLETED -> report.getContent();
                    };
                })
                .orElse("Отчет с таким ID не найден.");
    }
}
