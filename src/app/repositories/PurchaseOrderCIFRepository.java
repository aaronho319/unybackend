package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderCIF;

@Repository
public interface PurchaseOrderCIFRepository extends JpaRepository<PurchaseOrderCIF, Long>{

}
