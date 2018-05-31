package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

}
