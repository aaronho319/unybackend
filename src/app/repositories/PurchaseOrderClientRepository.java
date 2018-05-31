package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderClient;

@Repository
public interface PurchaseOrderClientRepository extends JpaRepository<PurchaseOrderClient, Long>{

}
