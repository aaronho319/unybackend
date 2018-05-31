package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.ReportCIF;

@Repository
public interface ReportCIFRepository extends JpaRepository<ReportCIF, Long>{

}
