package lt.svs.repositories;

import lt.svs.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository <Report, Long> {
    Report findReportByTitle (String title);
    void deleteReportByTitle(String title);
}
