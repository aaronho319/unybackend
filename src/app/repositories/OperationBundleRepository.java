package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.OperationBundle;

@Repository
public interface OperationBundleRepository extends JpaRepository<OperationBundle, Long>{

}
