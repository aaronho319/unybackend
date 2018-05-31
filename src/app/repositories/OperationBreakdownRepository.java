package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.OperationBreakdown;

@Repository
public interface OperationBreakdownRepository extends JpaRepository<OperationBreakdown, Long>{

}
