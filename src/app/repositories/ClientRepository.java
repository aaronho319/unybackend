package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
