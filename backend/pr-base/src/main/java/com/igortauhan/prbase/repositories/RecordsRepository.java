package com.igortauhan.prbase.repositories;

import com.igortauhan.prbase.models.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Long> {

    @Query(value = "SELECT * FROM tb_records WHERE ativo_id = ?1", nativeQuery = true)
    List<Records> getAllRecordsByAtivoId(Long id);
}
