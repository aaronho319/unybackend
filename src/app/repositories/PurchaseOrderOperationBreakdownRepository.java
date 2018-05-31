package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderOperationBreakdown;

@Repository
public interface PurchaseOrderOperationBreakdownRepository extends JpaRepository<PurchaseOrderOperationBreakdown, Long>{

}
