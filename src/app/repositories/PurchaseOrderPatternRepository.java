package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PurchaseOrderPattern;

@Repository
public interface PurchaseOrderPatternRepository extends JpaRepository<PurchaseOrderPattern, Long>{

}
