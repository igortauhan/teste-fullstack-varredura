package com.igortauhan.prbase.repositories;

import com.igortauhan.prbase.models.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Long> {
}
