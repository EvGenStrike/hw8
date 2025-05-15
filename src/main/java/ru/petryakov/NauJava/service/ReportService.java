package ru.petryakov.NauJava.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.petryakov.NauJava.entity.Report;
import ru.petryakov.NauJava.entity.ReportStatus;
import ru.petryakov.NauJava.repository.ReportRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Long createReport() {
        Report report = new Report();
        report.setStatus(ReportStatus.CREATED);
        reportRepository.save(report);
        return report.getId();
    }

    @Async
    public void generateReport(Long reportId) {
        CompletableFuture.runAsync(() -> {
            long startTime = System.currentTimeMillis();
            Report report = reportRepository.findById(reportId).orElseThrow();
            try {
                // Поток 1 – количество пользователей
                CompletableFuture<Long> userCountFuture = CompletableFuture.supplyAsync(() -> {
                    // Симуляция подсчёта пользователей
                    return 42L; // заглушка
                });

                // Поток 2 – список объектов
                CompletableFuture<List<String>> dataFuture = CompletableFuture.supplyAsync(() -> {
                    // Симуляция получения данных
                    return List.of("Object A", "Object B");
                });

                Long userCount = userCountFuture.join();
                List<String> dataList = dataFuture.join();

                long elapsed = System.currentTimeMillis() - startTime;

                // Составляем отчёт
                StringBuilder content = new StringBuilder();
                content.append("User count: ").append(userCount).append("\n");
                content.append("Objects: ").append(String.join(", ", dataList)).append("\n");
                content.append("Time: ").append(elapsed).append(" ms");

                report.setContent(content.toString());
                report.setStatus(ReportStatus.COMPLETED);
            } catch (Exception e) {
                report.setStatus(ReportStatus.ERROR);
                report.setContent("Ошибка при генерации отчета: " + e.getMessage());
            }

            reportRepository.save(report);
        });
    }

    @Async
    public void generateReportAsync(Long reportId) {
        Report report = reportRepository.findById(reportId).orElseThrow();
        try {
            Thread.sleep(1000); // эмуляция долгой генерации
            report.setContent("Сформированный отчет #" + reportId);
            report.setStatus(ReportStatus.COMPLETED);
        } catch (Exception e) {
            report.setStatus(ReportStatus.ERROR);
            report.setContent("Ошибка при формировании: " + e.getMessage());
        }
        reportRepository.save(report);
    }
}
