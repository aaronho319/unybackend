package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.PostingSheet;

@Repository
public interface PostingSheetRepository extends JpaRepository<PostingSheet, Long>{

}
