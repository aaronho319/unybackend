package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.OperationEmployee;

@Repository
public interface OperationEmployeeRepository extends JpaRepository<OperationEmployee, Long>{

}
