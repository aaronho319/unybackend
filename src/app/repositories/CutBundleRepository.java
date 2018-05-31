package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.CutBundle;

@Repository
public interface CutBundleRepository extends JpaRepository<CutBundle, Long>{

}
