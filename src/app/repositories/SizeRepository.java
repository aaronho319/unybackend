package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{

}
