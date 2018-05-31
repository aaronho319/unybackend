package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Bundle;

@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long> {

}

