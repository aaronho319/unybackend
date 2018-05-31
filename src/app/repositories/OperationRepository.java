package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

}
