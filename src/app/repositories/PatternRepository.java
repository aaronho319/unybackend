package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Pattern;

@Repository
public interface PatternRepository extends JpaRepository<Pattern, Long>{

}
