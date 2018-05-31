package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderReport;

@Repository
public interface PurchaseOrderReportRepository extends JpaRepository<PurchaseOrderReport, Long>{

}
