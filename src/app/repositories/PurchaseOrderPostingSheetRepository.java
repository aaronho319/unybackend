package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderPostingSheet;

@Repository
public interface PurchaseOrderPostingSheetRepository extends JpaRepository<PurchaseOrderPostingSheet, Long>{

}
