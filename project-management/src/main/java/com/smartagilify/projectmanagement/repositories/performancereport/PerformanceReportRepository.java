package com.smartagilify.projectmanagement.repositories.performancereport;

import com.smartagilify.projectmanagement.model.entities.PerformanceReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceReportRepository extends JpaRepository<PerformanceReport, Long> {
}
