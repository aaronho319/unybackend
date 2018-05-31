package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.CIF;

@Repository
public interface CIFRepository extends JpaRepository<CIF, Long>{

}
