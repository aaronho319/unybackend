package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.EmployeeBundle;

@Repository
public interface EmployeeBundleRepository extends JpaRepository<EmployeeBundle, Long>{

}
